package com.revature.Bank_App.ObjectModel;

import com.revature.Bank_App.util.LinkedList;

public abstract class Account {
    /*
        Abstract Account parent
     */
    private double accountBalance;
    private String accountName;
    private String accountNumber;
    private LinkedList<TransactionNode> transaction;



    //___________________________Getter Section__________________________
    public double getAccountBalance() {return accountBalance;}
    public String getAccountName() {return accountName;}
    public String getAccountNumber() {return accountNumber;}
    public LinkedList<TransactionNode> getTransaction() {return transaction;}


    //___________________________Setter Section_____________________________
    public void setAccountBalance(double accountBalance) {this.accountBalance = accountBalance;}
    public void addTransaction(TransactionNode transNode) {
        this.transaction.add(transNode);
    }

//     Might put to constructor
//    public void setAccountName(String accountName) {
//        this.accountName = accountName;
//    }


//     Might put to constructor
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }




}
