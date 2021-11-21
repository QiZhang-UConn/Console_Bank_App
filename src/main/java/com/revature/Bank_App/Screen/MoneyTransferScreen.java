package com.revature.Bank_App.Screen;

import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.Service.AccountService;
import com.revature.Bank_App.util.LinkedList;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.Bank_App.util.color.ANSI_BLUE;
import static com.revature.Bank_App.util.color.ANSI_RESET;

public class MoneyTransferScreen extends Screen{
    private AccountService accountService;
    public MoneyTransferScreen(BufferedReader consoleReader, ScreenRouter screenRouter,AccountService accountService) {
        super("Money Transfer Screen", "transfer", consoleReader, screenRouter);
        this.accountService=accountService;
    }

    @Override
    public void render() throws Exception {
        System.out.println(ANSI_BLUE+"Transfer: Money Moves~~~"+ANSI_RESET);

        System.out.println("Which account would you like to withdraw from?");
        LinkedList<Account> accounts=accountService.getAccounts();
        for(int i=0;i<accounts.getSize();i++) {
            System.out.println(i+")"+accounts.get(i).getAccountName());
        }
        String fromAccount=consoleReader.readLine();
        try {
            if (!(Integer.parseInt(fromAccount) >= 0 && Integer.parseInt(fromAccount) <accounts.getSize())) {
                System.out.println("Invalid Input");
            }else {
                System.out.println("Please input the amount you would like to withdraw");
                System.out.print(">");
                String amount = consoleReader.readLine();
                System.out.println("Which account would you like to transfer money to");
                String toAccount = consoleReader.readLine();
                if (!(Integer.parseInt(toAccount) >= 0 && Integer.parseInt(toAccount) <accounts.getSize())) {
                    System.out.println("Invalid Input");
                }
                else {
                    accountService.transfer(accounts.get(Integer.valueOf(fromAccount)),
                            accounts.get(Integer.valueOf(toAccount)), amount);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
