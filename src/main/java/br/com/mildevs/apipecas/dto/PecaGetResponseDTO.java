package br.com.mildevs.apipecas.dto;

import br.com.mildevs.apipecas.common.Categoria;

public class PecaGetResponseDTO {

  private long id;
  private String nome;
  private String modeloCarro;
  private String fabricante;
  private float precoVenda;
  private int quantidadeEstoque;
  private Categoria categoria;

  public PecaGetResponseDTO(
    long id,
    String nome,
    String modeloCarro,
    String fabricante,
    float precoVenda,
    int quantidadeEstoque,
    Categoria categoria
  ) {
    this.id = id;
    this.nome = nome;
    this.modeloCarro = modeloCarro;
    this.fabricante = fabricante;
    this.precoVenda = precoVenda;
    this.quantidadeEstoque = quantidadeEstoque;
    this.categoria = categoria;
  }

  public long getId() {
    return id;
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
