package br.com.mildevs.apipecas.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;

public class PecaUpdateDTO {

  @Min(value = 0, message = "O preço de custo deve ser maior ou igual a 0")
  @Digits(integer = 6, fraction = 2, message = "O preço de custo deve possuir no máximo 6 dígitos antes da vírgula e no máximo 2 após")
  private float precoCusto;

  @Min(value = 0, message = "O preço de venda deve ser maior ou igual a 0")
  @Digits(integer = 6, fraction = 2, message = "O preço de venda deve possuir no máximo 6 dígitos antes da vírgula e no máximo 2 após")
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
