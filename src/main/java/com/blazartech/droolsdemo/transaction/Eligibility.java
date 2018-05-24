/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.transaction;

/**
 *
 * @author AAR1069
 */
public class Eligibility {
    
    private Boolean eligibleToCalculate;
    private Boolean eligibleToDistribute;
    private Boolean eligibleToProduce;

    public Boolean getEligibleToCalculate() {
        return eligibleToCalculate;
    }

    public void setEligibleToCalculate(Boolean eligibleToCalculate) {
        this.eligibleToCalculate = eligibleToCalculate;
    }

    public Boolean getEligibleToDistribute() {
        return eligibleToDistribute;
    }

    public void setEligibleToDistribute(Boolean eligibleToDistribute) {
        this.eligibleToDistribute = eligibleToDistribute;
    }

    public Boolean getEligibleToProduce() {
        return eligibleToProduce;
    }

    public void setEligibleToProduce(Boolean eligibleToProduce) {
        this.eligibleToProduce = eligibleToProduce;
    }

    @Override
    public String toString() {
        return "Eligibility{" + "eligibleToCalculate=" + eligibleToCalculate + ", eligibleToDistribute=" + eligibleToDistribute + ", eligibleToProduce=" + eligibleToProduce + '}';
    }
    
    
}
