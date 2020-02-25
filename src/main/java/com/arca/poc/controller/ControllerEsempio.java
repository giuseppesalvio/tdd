package com.arca.poc.controller;

import com.arca.poc.dominio.TotaleBancaResponse;
import com.arca.poc.entity.ContoCorrente;
import com.arca.poc.service.TottaleAccountBancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class ControllerEsempio {

    @Autowired
    private TottaleAccountBancaService tottaleAccountBancaService ;

    @GetMapping("/totaleAccountBanca")
    public TotaleBancaResponse getTotaleAccountBanca(@RequestParam(value = "id") String id) {

        ContoCorrente totaleBAncaArrotndatoDaDB = tottaleAccountBancaService.getTotaleBAncaArrotndatoDaDB(id);


        TotaleBancaResponse TotaleBancaResponse = com.arca.poc.dominio.TotaleBancaResponse.builder().totaleConto(BigDecimal.valueOf(totaleBAncaArrotndatoDaDB.getSaldo())).codiceCliente(totaleBAncaArrotndatoDaDB.getId()).build();


        return TotaleBancaResponse;
    }
}
