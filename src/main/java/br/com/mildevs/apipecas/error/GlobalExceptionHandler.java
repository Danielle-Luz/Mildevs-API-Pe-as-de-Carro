package br.com.mildevs.apipecas.error;

import br.com.mildevs.apipecas.dto.ErroDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({ PecaNaoEncontradaException.class })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErroDTO handlePecaNaoEncontrada(PecaNaoEncontradaException e) {
    return new ErroDTO(e.getMessage());
  }

  @ExceptionHandler({ MethodArgumentNotValidException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public List<ErroDTO> handleFalhaValidacao(MethodArgumentNotValidException e) {
    List<ErroDTO> listaErrosValidacao = new ArrayList<>();

    e
      .getAllErrors()
      .forEach(error -> {
        listaErrosValidacao.add(new ErroDTO(error.getDefaultMessage()));
      });

    return listaErrosValidacao;
  }

  @ExceptionHandler({ HttpMessageNotReadableException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErroDTO handleTipoInvalido(HttpMessageNotReadableException e) {
    String mensagemAtualErro = e.getMessage();
    String novaMensagem;

    if (mensagemAtualErro.contains("Categoria")) {
      novaMensagem =
        "A categoria só pode ter um dos seguintes valores: FUNILARIA, MOTOR, PERFORMANCE ou SOM";
    } else if (mensagemAtualErro.contains("float")) {
      novaMensagem =
        "As propriedades 'precoCusto' e 'precoVenda' aceitam apenas valores numéricos";
    } else {
      novaMensagem =
        "A propriedade 'quantidadeEstoque' aceita apenas valores inteiros";
    }
    return new ErroDTO(novaMensagem);
  }
}
