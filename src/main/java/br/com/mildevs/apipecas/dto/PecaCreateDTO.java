package br.com.mildevs.apipecas.dto;

import br.com.mildevs.apipecas.common.Categoria;
import br.com.mildevs.apipecas.interfaces.PecaDTOGetters;
import jakarta.validation.constraints.NotBlank;

public class PecaCreateDTO implements PecaDTOGetters {

  @NotBlank
  private String nome;
  @NotBlank
  private String modeloCarro;
  @NotBlank
  private String fabricante;
  @NotBlank
  private float precoCusto;
  @NotBlank
  private float precoVenda;
  @NotBlank
  private int quantidadeEstoque;
  @NotBlank
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
