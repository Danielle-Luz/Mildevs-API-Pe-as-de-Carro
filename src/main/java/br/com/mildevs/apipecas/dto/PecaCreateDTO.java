package br.com.mildevs.apipecas.dto;

import br.com.mildevs.apipecas.common.Categoria;

public class PecaCreateDTO {

  private String nome;
  private String modeloCarro;
  private String fabricante;
  private float precoCusto;
  private float precoVenda;
  private int quantidadeEstoque;
  private Categoria categoria;

  public PecaCreateDTO(String nome, String modeloCarro, String fabricante, float precoCusto, float precoVenda,
      int quantidadeEstoque, Categoria categoria) {
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

  public float getPrecoCusto() {
    return precoCusto;
  }

  public void setPrecoCusto(float precoCusto) {
    this.precoCusto = precoCusto;
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
