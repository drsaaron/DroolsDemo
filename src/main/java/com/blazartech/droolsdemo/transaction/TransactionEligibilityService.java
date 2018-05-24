/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.transaction;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author AAR1069
 */
@Service
public class TransactionEligibilityService {
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionEligibilityService.class);
    
    @Autowired
    @Qualifier("transactionEligibilityRulesContainer")
    private KieContainer kieContainer;
 
    public Eligibility determineEligibility(Transaction transaction) {
        KieSession kieSession = kieContainer.newKieSession();
        
        Eligibility e = new Eligibility();
        kieSession.setGlobal("eligibility", e);
        kieSession.setGlobal("logger", logger);
        kieSession.insert(transaction);
        kieSession.fireAllRules();
        kieSession.dispose();
        return e;
    }
}
