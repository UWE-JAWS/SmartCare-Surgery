package com;

import java.math.BigDecimal;
/*
 * @author Simeon Dobchev
 * @author Joshua Saxby
 */
public class Fees {

    private int ID;
    private int PatientID;
    private BigDecimal TransactionAmount;
    private String TransactionDate;

    public Fees(int id, int patientId, BigDecimal transactionAmount, String transactionDate) {
        this.ID = id;
        this.PatientID = patientId;
        this.TransactionAmount = transactionAmount;
        this.TransactionDate = transactionDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientId) {
        this.PatientID = patientId;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.TransactionDate = transactionDate;
    }

    public BigDecimal getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.TransactionAmount = transactionAmount;
    }

    public String display() {
        return "Client ID: " + this.ID + " Client Name: " + this.PatientID + " Transaction Amount: "
                + this.TransactionAmount + " Transaction Date: " + this.TransactionDate;
    }
}
