package br.com.mildevs.apipecas.dto;

import br.com.mildevs.apipecas.interfaces.PecaDTOGetters;

public class PecaUpdateDTO implements PecaDTOGetters {

  private float precoCusto;
  private float precoVenda;
  private int quantidadeEstoque;

  public PecaUpdateDTO(
    float precoCusto,
    float precoVenda,
    int quantidadeEstoque
  ) {
    this.precoCusto = precoCusto;
    this.precoVenda = precoVenda;
    this.quantidadeEstoque = quantidadeEstoque;
  }

  public float getPrecoCusto() {
    return precoCusto;
  }

  public float getPrecoVenda() {
    return precoVenda;
  }

  public int getQuantidadeEstoque() {
    return quantidadeEstoque;
  }
}
