package br.com.mildevs.apipecas.service;

import br.com.mildevs.apipecas.common.Categoria;
import br.com.mildevs.apipecas.dto.PecaCreateDTO;
import br.com.mildevs.apipecas.dto.PecaGetResponseDTO;
import br.com.mildevs.apipecas.dto.PecaUpdateDTO;
import br.com.mildevs.apipecas.entity.PecaEntity;
import br.com.mildevs.apipecas.exception.PecaNaoEncontradaException;
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
    throws IllegalArgumentException {
    PecaEntity pecaEntity = new PecaEntity();
    BeanUtils.copyProperties(novaPeca, pecaEntity);
    repository.save(pecaEntity);

    return novaPeca;
  }

  public PecaUpdateDTO atualizaPeca(
    PecaUpdateDTO pecaAtualizada,
    long idPecaAtualizada
  ) throws PecaNaoEncontradaException {
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

  public List<PecaGetResponseDTO> buscaPecaPorNome(String nomeProcurado) {
    List<Optional<PecaEntity>> pecasEncontradasOptional = repository.findByNomeIgnoreCaseStartingWith(
      nomeProcurado
    );

    return converteListaOptionalParaListaPecasResponseDTO(
      pecasEncontradasOptional
    );
  }

  public List<PecaGetResponseDTO> buscarPecaPeloModeloCarro(
    String modeloCarroBuscado
  ) {
    List<Optional<PecaEntity>> pecasEncontradasOptional = repository.findByModeloCarroIgnoreCase(
      modeloCarroBuscado
    );

    return converteListaOptionalParaListaPecasResponseDTO(
      pecasEncontradasOptional
    );
  }

  public List<PecaGetResponseDTO> buscarPecaPelaCategoria(
    Categoria categoriaBuscada
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

    pecasEncontradasOptional.forEach(pecaOptional -> {
      PecaEntity pecaEntity = pecaOptional.get();
      PecaGetResponseDTO pecaResponseDTO = new PecaGetResponseDTO();
      BeanUtils.copyProperties(pecaEntity, pecaResponseDTO);

      pecasEncontradasResponse.add(pecaResponseDTO);
    });

    return pecasEncontradasResponse;
  }
}