package br.com.mildevs.apipecas.repository;

import br.com.mildevs.apipecas.entity.PecaEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends CrudRepository<PecaEntity, Long> {
  Optional<PecaEntity>[] findByNomeLike(String nome);

  Optional<PecaEntity>[] findByModeloCarro(String modeloCarro);

  Optional<PecaEntity>[] findByCategoria(String categoria);
}
