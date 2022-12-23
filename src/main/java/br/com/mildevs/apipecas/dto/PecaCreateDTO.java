package br.com.mildevs.apipecas.dto;

import br.com.mildevs.apipecas.common.Categoria;
import br.com.mildevs.apipecas.interfaces.PecaDTOGetters;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PecaCreateDTO implements PecaDTOGetters {

  @NotBlank(message = "O nome é obrigatório")
  private String nome;
  @NotBlank(message = "O modelo do carro do carro é obrigatório")
  private String modeloCarro;
  @NotBlank(message = "O fabricante é obrigatório")
  private String fabricante;
  @Min(value = 0, message = "O preço de custo deve ser maior ou igual a 0")
  private float precoCusto;
  @Min(value = 0, message = "O preço de venda deve ser maior ou igual a 0")
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
