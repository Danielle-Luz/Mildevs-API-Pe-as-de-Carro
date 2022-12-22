package br.com.mildevs.apipecas.entity;

import br.com.mildevs.apipecas.common.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Peca {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nome;
  private String modeloCarro;
  private String fabricante;
  private float precoCusto;
  private float precoVenda;
  private int quantidadeEstoque;

  @Enumerated(EnumType.STRING)
  private Categoria categoria;

  public Peca() {}

  public long getId() {
    return id;
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
