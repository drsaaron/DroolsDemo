/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.order;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * from https://docs.jboss.org/drools/release/5.2.0.Final/drools-expert-docs/html/ch05.html#d0e3962
 * 
 * @author AAR1069
 */
@Service
public class OrderTotalService {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderTotalService.class);
    
    @Autowired
    @Qualifier("orderRulesContainer")
    private KieContainer kieContainer;
    
    public void determineOrderTotal(Order order) {
        
        KieSession kieSession = kieContainer.newKieSession();
        
        kieSession.setGlobal("logger", logger);
        kieSession.insert(order);
        order.getOrderItems().forEach((item) -> {
            kieSession.insert(item);
        });
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
