package com.revature.Bank_App.Screen;

import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.Service.AccountService;
import com.revature.Bank_App.util.LinkedList;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;
import java.util.Locale;

public class AccountDetailScreen extends Screen{
    private AccountService accountService;
    public AccountDetailScreen(BufferedReader consoleReader, ScreenRouter screenRouter, AccountService accountService) {
        super("Account Detail Screen","detail", consoleReader, screenRouter);
        this.accountService=accountService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("Account Detail:");
        LinkedList<Account> accounts=accountService.getAccounts();
        if(accounts.getSize()==0){
            System.out.println("_________________________________________________________");
            System.out.println("You have no accounts yet, check out create account option");
            System.out.println("_________________________________________________________");
        }
        for(int i=0;i<accounts.getSize();i++){
            Account current=accounts.get(i);
            System.out.println("****************************");
            System.out.println("Account Number: "+current.getAccountNumber());
            System.out.println("Account Type: "+current.getAccountName().toUpperCase(Locale.ROOT));
            System.out.println("Account Owner: "+current.getUsername());
            System.out.println("Account balance: $"+df.format(current.getAccountBalance()));
            System.out.println("****************************");
        }

    }
}
