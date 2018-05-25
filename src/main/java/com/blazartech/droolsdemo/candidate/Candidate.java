/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.candidate;

/**
 *
 * @author AAR1069
 */
public class Candidate {
    
    private String status;
    private int yrsExperience;
    private Skill skill;
    private TestScore testScore;
    private InterviewScore interviewScore;
    private ProjectScore projectScore;

    public ProjectScore getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(ProjectScore projectScore) {
        this.projectScore = projectScore;
    }
    
    public InterviewScore getInterviewScore() {
        return interviewScore;
    }

    public void setInterviewScore(InterviewScore interviewScore) {
        this.interviewScore = interviewScore;
    }

    public TestScore getTestScore() {
        return testScore;
    }

    public void setTestScore(TestScore testScore) {
        this.testScore = testScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYrsExperience() {
        return yrsExperience;
    }

    public void setYrsExperience(int yrsExperience) {
        this.yrsExperience = yrsExperience;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    
    
}
