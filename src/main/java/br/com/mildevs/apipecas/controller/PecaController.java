package br.com.mildevs.apipecas.controller;

import br.com.mildevs.apipecas.dto.PecaCreateDTO;
import br.com.mildevs.apipecas.dto.PecaGetResponseDTO;
import br.com.mildevs.apipecas.dto.PecaUpdateDTO;
import br.com.mildevs.apipecas.error.CategoriaInvalidaException;
import br.com.mildevs.apipecas.error.NumeroNegativoException;
import br.com.mildevs.apipecas.error.PecaNaoEncontradaException;
import br.com.mildevs.apipecas.service.PecaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pecas")
public class PecaController {

  @Autowired
  PecaService service;

  @GetMapping(path = "{texto}/comeco")
  public List<PecaGetResponseDTO> buscarPecaPeloNome(
    @PathVariable String texto
  ) {
    return service.buscaPecaPorNome(texto);
  }

  @GetMapping(path = "{modelo}/modelo")
  public List<PecaGetResponseDTO> buscarPecaPeloModeloCarro(
    @PathVariable String modelo
  ) {
    return service.buscarPecaPeloModeloCarro(modelo);
  }

  @GetMapping(path = "{categoria}/categoria")
  public List<PecaGetResponseDTO> buscarPelaCategoria(
    @PathVariable String categoria
  ) {
    return service.buscarPecaPelaCategoria(categoria);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PecaCreateDTO criarPeca(@Valid @RequestBody PecaCreateDTO novaPeca)
    throws NumeroNegativoException, IllegalArgumentException, CategoriaInvalidaException {
    return service.criaPeca(novaPeca);
  }

  @PatchMapping(path = "/{idPecaAtualizada}")
  public PecaUpdateDTO atualizarPeca(
    @RequestBody PecaUpdateDTO pecaAtualizada,
    @PathVariable long idPecaAtualizada
  ) throws NumeroNegativoException, PecaNaoEncontradaException {
    return service.atualizaPeca(pecaAtualizada, idPecaAtualizada);
  }
}
