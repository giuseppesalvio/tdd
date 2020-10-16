package com.fincons.tdd.controllers;

import com.fincons.tdd.entitys.Anagrafica;
import com.fincons.tdd.repository.AnagraficaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class anagraficaController {
  private AnagraficaRepository anagraficaRepository;

  @PostMapping("/insert")
  public int getTotaleAccountBancaPost(@RequestBody Anagrafica anagrafica) {
    return anagraficaRepository.insert(anagrafica);
  }

  @GetMapping("/getAll")
  public List<Anagrafica> getAll() {
    return anagraficaRepository.getAll();
  }

  //TODO inserisci o modifica anagrafica a seconda se l'id è gia presente o meno
  @PostMapping("/inserisciModifica")
  public Anagrafica modificaAnagrafica(@RequestBody Anagrafica anagrafica) {
    return new Anagrafica();
  }

}
