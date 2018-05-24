/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.sum;

import com.blazartech.droolsdemo.transaction.Eligibility;
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
public class SumService {
    
    private static final Logger logger = LoggerFactory.getLogger(SumService.class);
    
    @Autowired
    @Qualifier("sumRulesContainer")
    private KieContainer kieContainer;
    
    public Sum addValues(int initialValue, int addedValue) {
        KieSession kieSession = kieContainer.newKieSession();
        
        Sum s = new Sum();
        s.setValue(initialValue);
        
        Add a = new Add();
        a.setValue(addedValue);

        kieSession.setGlobal("sum", s);
        kieSession.setGlobal("logger", logger);
        kieSession.insert(a);
        kieSession.fireAllRules();
        kieSession.dispose();
        return s;
    }
}
