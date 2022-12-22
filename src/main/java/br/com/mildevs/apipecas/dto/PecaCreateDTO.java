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
