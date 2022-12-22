package br.com.mildevs.apipecas.repository;

import br.com.mildevs.apipecas.entity.PecaEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends CrudRepository<PecaEntity, Long> {
  List<Optional<PecaEntity>> findByNomeLike(String nome);

  List<Optional<PecaEntity>> findByModeloCarro(String modeloCarro);

  List<Optional<PecaEntity>> findByCategoria(String categoria);
}
