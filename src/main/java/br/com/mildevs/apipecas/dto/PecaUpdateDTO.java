package br.com.mildevs.apipecas.dto;

import jakarta.validation.constraints.Min;

public class PecaUpdateDTO {

  @Min(value = 0, message = "O preço de custo deve ser maior ou igual a 0")
  private float precoCusto;

  @Min(value = 0, message = "O preço de venda deve ser maior ou igual a 0")
  private float precoVenda;

  @Min(value = 0, message = "A quantidade em estoque mínima é 0")
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
