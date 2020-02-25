package com.arca.poc.service;

import com.arca.poc.dominio.TotaleBancaResponse;
import com.arca.poc.entity.ContoCorrente;
import com.arca.poc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TottaleAccountBancaService {

    @Autowired private AccountRepository accountRepository ;



    public ContoCorrente getTotaleBAncaArrotndatoDaDB(String idUtente){

       return accountRepository.getTotaleContoPerAccount(idUtente);



    }
}
