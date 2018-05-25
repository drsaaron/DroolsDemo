/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.candidate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author AAR1069
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    CandidateConfiguration.class,
    CandidateProgressionServiceTest.CandidateProgressionServiceTestConfiguration.class
})
public class CandidateProgressionServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(CandidateProgressionServiceTest.class);
    
    @Configuration
    static class CandidateProgressionServiceTestConfiguration {
        
        @Bean
        public CandidateProgressionService getCandidateProgressionService() {
            return new CandidateProgressionService();
        }
    }
    
    @Autowired
    private CandidateProgressionService service;
    
    public CandidateProgressionServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of progressCandidate method, of class CandidateProgressionService.
     */
    @Test
    public void testProgressCandidateSubmitted() {
        logger.info("progressCandidate");
        
        Candidate c = new Candidate();
        c.setStatus("Submitted");
        c.setYrsExperience(15);
        
        Skill s = new Skill();
        s.setName("java");
        s.setYrsExperience(4);
        c.setSkill(s);
        
        Candidate result = service.progressCandidate(c);
        
        assertEquals("Submitted", result.getStatus());
    }
    
    @Test
    public void testProgressCandidateTesting() {
        logger.info("progressCandidate");
        
        Candidate c = new Candidate();
        c.setStatus("Submitted");
        c.setYrsExperience(15);
        
        Skill s = new Skill();
        s.setName("java");
        s.setYrsExperience(8);
        c.setSkill(s);
        
        Candidate result = service.progressCandidate(c);
        
        assertEquals("Testing", result.getStatus());
    }
    
    @Test
    public void testProgressCandidateInterview() {
        logger.info("progressCandidate");
        
        Candidate c = new Candidate();
        c.setStatus("Testing");
        c.setYrsExperience(15);
        
        Skill s = new Skill();
        s.setName("java");
        s.setYrsExperience(8);
        c.setSkill(s);
        
        TestScore score = new TestScore();
        score.setProblemSolving(0.9f);
        score.setSyntax(0.9f);
        score.setTheory(0.9f);
        c.setTestScore(score);
        
        Candidate result = service.progressCandidate(c);
        
        assertEquals("Interview", result.getStatus());
    }
}
