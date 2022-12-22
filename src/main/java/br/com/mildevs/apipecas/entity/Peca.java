package br.com.mildevs.apipecas.entity;

import br.com.mildevs.apipecas.common.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Peca {
  private String nome;
  private String modeloCarro;
  private String fabricante;
  private float precoCusto;
  private float precoVenda;
  private int quantidadeEstoque;
  @Enumerated(EnumType.STRING)
  private Categoria categoria;
}
