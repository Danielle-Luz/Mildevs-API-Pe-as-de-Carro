package br.com.mildevs.apipecas.service;

import br.com.mildevs.apipecas.dto.PecaCreateDTO;
import br.com.mildevs.apipecas.dto.PecaGetResponseDTO;
import br.com.mildevs.apipecas.dto.PecaUpdateDTO;
import br.com.mildevs.apipecas.entity.PecaEntity;
import br.com.mildevs.apipecas.error.NumeroNegativoException;
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
    throws NumeroNegativoException, IllegalArgumentException {
    if (novaPeca.getPrecoCusto() < 0) {
      throw new NumeroNegativoException(
        "O preço de custo deve ser um valor maior ou igual a zero"
      );
    } else if (novaPeca.getPrecoVenda() < 0) {
      throw new NumeroNegativoException(
        "O preço de venda deve ser um valor maior ou igual a zero"
      );
    } else if (novaPeca.getQuantidadeEstoque() < 0) {
      throw new NumeroNegativoException(
        "A quantidade em estoque deve ser um valor maior ou igual a zero"
      );
    }

    PecaEntity pecaEntity = new PecaEntity();
    BeanUtils.copyProperties(novaPeca, pecaEntity);
    repository.save(pecaEntity);

    return novaPeca;
  }

  public PecaUpdateDTO atualizaPeca(
    PecaUpdateDTO pecaAtualizada,
    long idPecaAtualizada
  ) throws NumeroNegativoException {
    if (pecaAtualizada.getPrecoCusto() < 0) {
      throw new NumeroNegativoException(
        "O preço de custo deve ser um valor maior ou igual a zero"
      );
    } else if (pecaAtualizada.getPrecoVenda() < 0) {
      throw new NumeroNegativoException(
        "O preço de venda deve ser um valor maior ou igual a zero"
      );
    } else if (pecaAtualizada.getQuantidadeEstoque() < 0) {
      throw new NumeroNegativoException(
        "A quantidade em estoque deve ser um valor maior ou igual a zero"
      );
    }

    PecaEntity pecaEntity = repository.findById(idPecaAtualizada).get();
    BeanUtils.copyProperties(pecaAtualizada, pecaEntity);
    repository.save(pecaEntity);

    return pecaAtualizada;
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
}
