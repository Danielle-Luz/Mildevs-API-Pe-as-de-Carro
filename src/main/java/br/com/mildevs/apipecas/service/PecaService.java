package br.com.mildevs.apipecas.service;

import br.com.mildevs.apipecas.dto.PecaCreateDTO;
import br.com.mildevs.apipecas.entity.PecaEntity;
import br.com.mildevs.apipecas.error.NumeroNegativoException;
import br.com.mildevs.apipecas.repository.PecaRepository;
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
}
