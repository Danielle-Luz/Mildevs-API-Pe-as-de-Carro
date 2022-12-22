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

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getModeloCarro() {
    return modeloCarro;
  }

  public void setModeloCarro(String modeloCarro) {
    this.modeloCarro = modeloCarro;
  }

  public String getFabricante() {
    return fabricante;
  }

  public void setFabricante(String fabricante) {
    this.fabricante = fabricante;
  }

  public float getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(float precoVenda) {
    this.precoVenda = precoVenda;
  }

  public int getQuantidadeEstoque() {
    return quantidadeEstoque;
  }

  public void setQuantidadeEstoque(int quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }
}
