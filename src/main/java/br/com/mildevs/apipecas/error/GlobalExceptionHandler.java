package br.com.mildevs.apipecas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.mildevs.apipecas.dto.ErroDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(NumeroNegativoException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ErroDTO handleNumeroNegativoException(NumeroNegativoException e) {
    return new ErroDTO(e.getMessage());
  }
}
