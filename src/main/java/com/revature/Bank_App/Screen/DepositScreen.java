package com.revature.Bank_App.Screen;

import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.Service.AccountService;
import com.revature.Bank_App.util.LinkedList;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.Bank_App.util.color.ANSI_BLUE;
import static com.revature.Bank_App.util.color.ANSI_RESET;

public class DepositScreen extends Screen{
    private AccountService accountService;
    //DepositScreen Constructor
    public DepositScreen(BufferedReader consoleReader, ScreenRouter screenRouter,AccountService accountService) {
        super("Deposit Screen", "deposit", consoleReader, screenRouter);
        this.accountService=accountService;
    }

    @Override
    public void render() throws Exception {
        System.out.println(ANSI_BLUE+"Deposit!"+ANSI_RESET);
        System.out.println("Which account would you like to deposit into?");
        LinkedList<Account> accounts=accountService.getAccounts();
        for(int i=0;i<accounts.getSize();i++) {
            System.out.println(i+")"+accounts.get(i).getAccountName());
        }
        String userSelection=consoleReader.readLine();
        try {
            if (!(Integer.parseInt(userSelection) >= 0 && Integer.parseInt(userSelection) <accounts.getSize())) {
                System.out.println("Invalid Input");
            } else {
                System.out.println("Please input the amount you would like to deposit");
                System.out.print(">");
                String amount = consoleReader.readLine();
                accountService.deposit(accounts.get(Integer.valueOf(userSelection)), amount);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
