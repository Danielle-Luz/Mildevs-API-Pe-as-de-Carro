package br.com.mildevs.apipecas.controller;

import br.com.mildevs.apipecas.common.Categoria;
import br.com.mildevs.apipecas.dto.PecaCreateDTO;
import br.com.mildevs.apipecas.dto.PecaGetResponseDTO;
import br.com.mildevs.apipecas.dto.PecaUpdateDTO;
import br.com.mildevs.apipecas.exception.PecaNaoEncontradaException;
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

  @GetMapping
  public List<PecaGetResponseDTO> buscaTodasPecas() {
    return service.buscaTodasPecas();
  }

  @GetMapping(path = "/{texto}/comeco")
  public List<PecaGetResponseDTO> buscarPecaPeloNome(
    @PathVariable String texto
  ) {
    return service.buscaPecaPorNome(texto);
  }

  @GetMapping(path = "/{modelo}/modelo")
  public List<PecaGetResponseDTO> buscarPecaPeloModeloCarro(
    @PathVariable String modelo
  ) {
    return service.buscarPecaPeloModeloCarro(modelo);
  }

  @GetMapping(path = "/{categoria}/categoria")
  public List<PecaGetResponseDTO> buscarPelaCategoria(
    @PathVariable Categoria categoria
  ) {
    return service.buscarPecaPelaCategoria(categoria);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PecaCreateDTO criarPeca(@Valid @RequestBody PecaCreateDTO novaPeca)
    throws IllegalArgumentException {
    return service.criaPeca(novaPeca);
  }

  @PatchMapping(path = "/{idPecaAtualizada}")
  public PecaUpdateDTO atualizarPeca(
    @Valid @RequestBody PecaUpdateDTO pecaAtualizada,
    @PathVariable long idPecaAtualizada
  ) throws PecaNaoEncontradaException {
    return service.atualizaPeca(pecaAtualizada, idPecaAtualizada);
  }
}
