/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.candidate;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * see https://www.toptal.com/java/rules-engines-power-to-the-smeople
 * 
 * @author AAR1069
 */
@Service
public class CandidateProgressionService {
    
    private static final Logger logger = LoggerFactory.getLogger(CandidateProgressionService.class);
    
    @Autowired
    @Qualifier("candidateRulesContainer")
    private KieContainer kieContainer;
    
    public Candidate progressCandidate(Candidate c) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("logger", logger);
        kieSession.insert(c);
        kieSession.fireAllRules();
        kieSession.dispose();
        return c;
    }
}
