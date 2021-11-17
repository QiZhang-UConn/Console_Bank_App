package com.revature.Bank_App.ObjectModel;

import com.revature.Bank_App.util.LinkedList;

public class Account {
    /*
        Abstract Account parent
     */
    private double accountBalance;
    private String accountName;
    private String accountNumber;
    private String username;
    private LinkedList<TransactionNode> transaction;

    public Account(String accountName,String accountNumber,String username){
        this.accountName=accountName;
        this.accountNumber=accountNumber;
        this.username=username;
    }
    public Account(){};

    public int getType(){
        if(accountName=="checking") return 1;
        if(accountName=="saving") return 2;
        if(accountName=="investment") return 3;
        return 0;
    }

    //___________________________Getter Section__________________________
    public double getAccountBalance() {return accountBalance;}
    public String getAccountName() {return accountName;}
    public String getAccountNumber() {return accountNumber;}
    public LinkedList<TransactionNode> getTransaction() {return transaction;}
    public String getUsername() {return username;}


    //___________________________Setter Section_____________________________
    public void setAccountBalance(double accountBalance) {this.accountBalance = accountBalance;}
    public void addTransaction(TransactionNode transNode) {
        this.transaction.add(transNode);
    }
    public void setAccountName(String accountName) {this.accountName = accountName;}
    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
    public void setUsername(String username) {this.username = username;}



}
