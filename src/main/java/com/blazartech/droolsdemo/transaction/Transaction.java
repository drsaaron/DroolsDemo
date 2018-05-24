/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.transaction;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author AAR1069
 */
public class Transaction {
    
    private Long id;
    private String dsbNumber;
    private int compensationProgram;
    private Date effectiveDate;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDsbNumber() {
        return dsbNumber;
    }

    public void setDsbNumber(String dsbNumber) {
        this.dsbNumber = dsbNumber;
    }

    public int getCompensationProgram() {
        return compensationProgram;
    }

    public void setCompensationProgram(int compensationProgram) {
        this.compensationProgram = compensationProgram;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    
}
