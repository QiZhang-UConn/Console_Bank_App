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
                           "2) Deposit money into an account"+
                           "3) Withdraw money from an account"+
                           "4) View Account balance"+//might be removed so shows directly in dashboard
                           "5) View transaction of an account"+
                           "6) Transfer money between accounts"+
                           "7) Exit");
    }
}
