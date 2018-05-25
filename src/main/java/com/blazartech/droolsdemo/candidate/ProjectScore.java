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
public class ProjectScore {
    
    private float completeness;
    private float architecture;
    private float gui;

    public float getCompleteness() {
        return completeness;
    }

    public void setCompleteness(float completeness) {
        this.completeness = completeness;
    }

    public float getArchitecture() {
        return architecture;
    }

    public void setArchitecture(float architecture) {
        this.architecture = architecture;
    }

    public float getGui() {
        return gui;
    }

    public void setGui(float gui) {
        this.gui = gui;
    }
    
    
}
