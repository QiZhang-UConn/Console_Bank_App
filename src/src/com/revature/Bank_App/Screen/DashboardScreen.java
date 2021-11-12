package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class DashboardScreen extends Screen{

    //DashboardScreen Constructor
    public DashboardScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Dashboard Screen","dashboard", consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to Dashboard!");
        //TODO: implement Dashboard feature: Show balance, navigate to Deposit, Withdraw, or ShowTransaction
    }
}
