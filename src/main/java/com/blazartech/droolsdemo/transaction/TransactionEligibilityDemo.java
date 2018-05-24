/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.transaction;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author AAR1069
 */
@Component
public class TransactionEligibilityDemo implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TransactionEligibilityDemo.class);
    
    @Autowired
    private TransactionEligibilityService service;
    
    @Override
    public void run(String... args) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("50000"));
        transaction.setCompensationProgram(1);
        transaction.setDsbNumber("0ABCDE");
        transaction.setEffectiveDate(java.sql.Date.valueOf("2018-01-01"));
        transaction.setId(1L);
        
        Eligibility result = service.determineEligibility(transaction);
        
        logger.info("eligibility = " + result.toString());
        
        transaction.setCompensationProgram(2);
        result = service.determineEligibility(transaction);
        logger.info("eligibility = " + result);
    }
    
}
