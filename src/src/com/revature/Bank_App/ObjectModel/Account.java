package com.revature.Bank_App.ObjectModel;

import com.revature.Bank_App.util.LinkedList;

public abstract class Account {
    /*
        Abstract Account parent
        TODO: if time is enough create multi account system with Account class and its children classes
     */
    private double accountBalance;
    private String accountName;
    private LinkedList<TransactionNode> transaction;


}
