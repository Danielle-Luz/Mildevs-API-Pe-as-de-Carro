package br.com.mildevs.apipecas.entity;

import jakarta.persistence.Entity;

@Entity
public class Peca {
  String nome;
  String modeloCarro;
  String fabricante;
  float precoCusto;
  float precoVenda;
  int quantidadeEstoque;
  
}
