package com.revature.Bank_App.ObjectModel;

import com.revature.Bank_App.util.LinkedList;

public class Account {
    /*
        Abstract Account parent
     */
    private double accountBalance;
    private final String accountName;
    private final String accountNumber;
    private final String username;
    private LinkedList<TransactionNode> transaction;

    public Account(String accountName,String accountNumber,String username){
        this.accountName=accountName;
        this.accountNumber=accountNumber;
        this.username=username;
    }


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


//     Might put to constructor
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }




}
