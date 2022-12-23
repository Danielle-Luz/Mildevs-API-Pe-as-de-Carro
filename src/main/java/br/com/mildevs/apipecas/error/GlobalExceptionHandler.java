package br.com.mildevs.apipecas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.mildevs.apipecas.dto.ErroDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler({NumeroNegativoException.class})
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ErroDTO handleNumeroNegativoException(NumeroNegativoException e) {
    return new ErroDTO(e.getMessage());
  }

  @ExceptionHandler({IllegalArgumentException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErroDTO handleIllegalArgumentException(IllegalArgumentException e) {
    return new ErroDTO("A categoria precisa ter um dos seguintes valores: FUNILARIA, MOTOR, PERFORMANCE, SOM");
  }

  @ExceptionHandler({PecaNaoEncontradaException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErroDTO handlePecaNaoEncontradaException(PecaNaoEncontradaException e) {
    return new ErroDTO(e.getMessage());  
  }
}
