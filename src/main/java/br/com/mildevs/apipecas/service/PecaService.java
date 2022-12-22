package br.com.mildevs.apipecas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mildevs.apipecas.entity.PecaEntity;

@Service
public class PecaService {
  @Autowired
  PecaEntity entity;
}
