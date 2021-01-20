package Pages;

public class Fees {

    private int ID;
    private int PatientID;
    private double TransactionAmount;
    private String TransactionDate;

    public Fees(int id, int patientId, double transactionAmount, String transactionDate) {
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

    public double getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.TransactionAmount = transactionAmount;
    }

    public String display() {
        return "Client ID: " + this.ID + " Client Name: " + this.PatientID + " Transaction Amount: "
                + this.TransactionAmount + " Transaction Date: " + this.TransactionDate;
    }
}
