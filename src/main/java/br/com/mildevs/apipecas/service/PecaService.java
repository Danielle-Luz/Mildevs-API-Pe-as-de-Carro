package br.com.mildevs.apipecas.service;

import br.com.mildevs.apipecas.dto.PecaCreateDTO;
import br.com.mildevs.apipecas.dto.PecaGetResponseDTO;
import br.com.mildevs.apipecas.dto.PecaUpdateDTO;
import br.com.mildevs.apipecas.entity.PecaEntity;
import br.com.mildevs.apipecas.error.CategoriaInvalidaException;
import br.com.mildevs.apipecas.error.NumeroNegativoException;
import br.com.mildevs.apipecas.error.PecaNaoEncontradaException;
import br.com.mildevs.apipecas.interfaces.PecaDTOGetters;
import br.com.mildevs.apipecas.repository.PecaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PecaService {

  @Autowired
  PecaRepository repository;

  public PecaCreateDTO criaPeca(PecaCreateDTO novaPeca)
    throws NumeroNegativoException, IllegalArgumentException, CategoriaInvalidaException {
    emiteNumeroNegativoException(novaPeca);
    emiteCategoriaInvalidaException(novaPeca);

    PecaEntity pecaEntity = new PecaEntity();
    BeanUtils.copyProperties(novaPeca, pecaEntity);
    repository.save(pecaEntity);

    return novaPeca;
  }

  public PecaUpdateDTO atualizaPeca(
    PecaUpdateDTO pecaAtualizada,
    long idPecaAtualizada
  ) throws NumeroNegativoException, PecaNaoEncontradaException {
    emiteNumeroNegativoException(pecaAtualizada);

    PecaEntity pecaEntity = repository.findById(idPecaAtualizada).get();

    if (pecaEntity == null) {
      throw new PecaNaoEncontradaException(
        "Não foi possível atualizar a peça, ela não foi encontrada"
      );
    }

    BeanUtils.copyProperties(pecaAtualizada, pecaEntity);
    repository.save(pecaEntity);

    return pecaAtualizada;
  }

  private void emiteNumeroNegativoException(PecaDTOGetters peca)
    throws NumeroNegativoException {
    if (peca.getPrecoCusto() < 0) {
      throw new NumeroNegativoException(
        "O preço de custo deve ser um valor maior ou igual a zero"
      );
    } else if (peca.getPrecoVenda() < 0) {
      throw new NumeroNegativoException(
        "O preço de venda deve ser um valor maior ou igual a zero"
      );
    } else if (peca.getQuantidadeEstoque() < 0) {
      throw new NumeroNegativoException(
        "A quantidade em estoque deve ser um valor maior ou igual a zero"
      );
    }
  }

  private void emiteCategoriaInvalidaException(PecaCreateDTO novaPeca)
    throws CategoriaInvalidaException {
    String categoriaPeca = novaPeca.getCategoria().name();
    String categoriasValidas = "^(FUNILARIA|MOTOR|PERFORMANCE|SOM)$";

    if (!categoriaPeca.matches(categoriasValidas)) {
      throw new CategoriaInvalidaException(
        "A categoria só pode ter um dos seguintes valores: FUNILARIA, MOTOR, PERFORMANCE ou SOM"
      );
    }
  }

  public List<PecaGetResponseDTO> buscaPecaPorNome(String nomeProcurado) {
    List<Optional<PecaEntity>> pecasEncontradasOptional = repository.findByNomeLike(
      nomeProcurado
    );

    return converteListaOptionalParaListaPecasResponseDTO(
      pecasEncontradasOptional
    );
  }

  public List<PecaGetResponseDTO> buscarPecaPeloModeloCarro(
    String modeloCarroBuscado
  ) {
    List<Optional<PecaEntity>> pecasEncontradasOptional = repository.findByModeloCarro(
      modeloCarroBuscado
    );

    return converteListaOptionalParaListaPecasResponseDTO(
      pecasEncontradasOptional
    );
  }

  public List<PecaGetResponseDTO> buscarPecaPelaCategoria(
    String categoriaBuscada
  ) {
    List<Optional<PecaEntity>> pecasEncontradasOptional = repository.findByCategoria(
      categoriaBuscada
    );

    return converteListaOptionalParaListaPecasResponseDTO(
      pecasEncontradasOptional
    );
  }

  private List<PecaGetResponseDTO> converteListaOptionalParaListaPecasResponseDTO(
    List<Optional<PecaEntity>> pecasEncontradasOptional
  ) {
    List<PecaGetResponseDTO> pecasEncontradasResponse = new ArrayList<>();

    for (Optional<PecaEntity> pecaOptional : pecasEncontradasOptional) {
      PecaEntity pecaEntity = pecaOptional.get();
      PecaGetResponseDTO pecaResponseDTO = new PecaGetResponseDTO();
      BeanUtils.copyProperties(pecaEntity, pecaResponseDTO);

      pecasEncontradasResponse.add(pecaResponseDTO);
    }

    return pecasEncontradasResponse;
  }
}
