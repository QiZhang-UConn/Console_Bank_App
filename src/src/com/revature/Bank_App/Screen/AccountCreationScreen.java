package com.revature.Bank_App.Screen;

import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.Service.AccountService;
import com.revature.Bank_App.Service.UserService;
import com.revature.Bank_App.util.LinkedList;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class AccountCreationScreen extends Screen{
    private AccountService accountService;

    public AccountCreationScreen(BufferedReader consoleReader, ScreenRouter screenRouter, AccountService accountService) {
        super("Create Account Screen", "create", consoleReader, screenRouter);
        this.accountService=accountService;
    }

    @Override
    public void render() throws Exception {
        int numAccount=accountService.getAccountNum();
        System.out.println("Welcome You have "+numAccount+" Accounts");
        if (numAccount==3) {
            System.out.println("___________________________________________________");
            System.out.println("You have all account types we provided. Thank You!");
            System.out.println("___________________________________________________");
        }
        else {
            System.out.println("You may create following accounts: \n");
            LinkedList<String> missing=accountService.exportMissingAccount();
            for(int i=0;i< missing.getSize();i++){
                System.out.println(i+") "+missing.get(i)+"\n");
            }
            String userSelection=consoleReader.readLine();
            try {
                if (userSelection == null || userSelection.trim().equals("")) System.out.println("invalid input");
                else {
                    String accountType = missing.get(Integer.parseInt(userSelection));
                    if (accountType == null) {
                        System.out.println("invalid input");
                    }
                    else{
                        accountService.createAccount(accountType);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
