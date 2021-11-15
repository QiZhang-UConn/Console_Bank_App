package com.revature.Bank_App.Screen;

import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class DashboardScreen extends Screen{
    private final AppUser sessionUser;

    //DashboardScreen Constructor
    public DashboardScreen(BufferedReader consoleReader, ScreenRouter screenRouter, AppUser sessionUser) {
        super("Dashboard Screen","dashboard", consoleReader, screenRouter);
        //Takes over the session user
        this.sessionUser=sessionUser;
        //Once Dashboard Instantiated, user allowed to access the private screens
        screenRouter.addScreen(new DashboardScreen(consoleReader,screenRouter,sessionUser));
        screenRouter.addScreen(new DashboardScreen(consoleReader,screenRouter,sessionUser));
        screenRouter.addScreen(new DashboardScreen(consoleReader,screenRouter,sessionUser));
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to Dashboard!");
        System.out.println("What do you want to do today?");
        System.out.println("1) Create an account\n"+
                           "2) Deposit money into an account\n"+
                           "3) Withdraw money from an account\n"+
                           "4) View Account balance\n"+//might be removed so shows directly in dashboard
                           "5) View transaction of an account\n"+
                           "6) Transfer money between accounts\n"+
                           "7) Exit");
        String userSelection=consoleReader.readLine();
        switch (userSelection){
            case "1":
                //TODO: Create an account
            case "2":
                //TODO: Deposit page implementation
            case "3":
                //TODO: Withdraw page implementation
            case "4":
                //TODO: View Account balance
            case "5":
                //TODO: Transaction of an account
            case "6":
                //TODO: Transfer money between accounts
            case "7":
                screenRouter.navigate("welcome");
        }
    }
}
