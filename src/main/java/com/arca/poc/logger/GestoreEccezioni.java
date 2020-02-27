package com.arca.poc.logger;

import com.arca.poc.repository.AccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GestoreEccezioni {


    private static final Logger logger = LogManager.getLogger(AccountRepository.class);

    @ExceptionHandler(Exception.class)
    public void gesteroEccezioni(Exception e){

        logger.info("Eccezione " + e);


    }
}
