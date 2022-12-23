package br.com.mildevs.apipecas.error;

public class PecaNaoEncontradaException extends Exception {
  public PecaNaoEncontradaException(String mensagem) {
    super(mensagem);
  }
}
