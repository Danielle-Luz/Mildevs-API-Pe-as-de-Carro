package br.com.mildevs.apipecas.dto;

import br.com.mildevs.apipecas.common.Categoria;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PecaCreateDTO {

  @NotBlank(message = "O nome é obrigatório")
  @Size(max = 50, message = "O nome da peça deve ser uma palavra com no máximo 50 caracteres")
  private String nome;

  @NotBlank(message = "O modelo do carro do carro é obrigatório")
  @Size(max = 50, message = "O modelo do carro deve ser uma palavra com no máximo 50 caracteres")
  private String modeloCarro;

  @NotBlank(message = "O fabricante é obrigatório")
  @Size(max = 50, message = "O fabricante deve ser uma palavra com no máximo 50 caracteres")
  private String fabricante;

  @Min(value = 0, message = "O preço de custo deve ser maior ou igual a 0")
  @Digits(integer = 6, fraction = 2, message = "O preço de custo deve possuir no máximo 6 dígitos antes da vírgula e no máximo 2 após")
  private float precoCusto;

  @Min(value = 0, message = "O preço de venda deve ser maior ou igual a 0")
  @Digits(integer = 6, fraction = 2, message = "O preço de venda deve possuir no máximo 6 dígitos antes da vírgula e no máximo 2 após")
  private float precoVenda;

  @Min(value = 0, message = "A quantidade em estoque mínima é 0")
  private int quantidadeEstoque;

  private Categoria categoria;

  public PecaCreateDTO(
    String nome,
    String modeloCarro,
    String fabricante,
    float precoCusto,
    float precoVenda,
    int quantidadeEstoque,
    Categoria categoria
  ) {
    this.nome = nome;
    this.modeloCarro = modeloCarro;
    this.fabricante = fabricante;
    this.precoCusto = precoCusto;
    this.precoVenda = precoVenda;
    this.quantidadeEstoque = quantidadeEstoque;
    this.categoria = categoria;
  }

  public String getNome() {
    return nome;
  }

  public String getModeloCarro() {
    return modeloCarro;
  }

  public String getFabricante() {
    return fabricante;
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

  public Categoria getCategoria() {
    return categoria;
  }
}
