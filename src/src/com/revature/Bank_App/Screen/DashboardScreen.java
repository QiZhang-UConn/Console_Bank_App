package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class DashboardScreen extends Screen{

    //DashboardScreen Constructor
    public DashboardScreen(String screenName, String routingString, BufferedReader consoleReader, ScreenRouter screenRouter) {
        super(screenName, routingString, consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to Dashboard!");
        //TODO: implement Dashboard feature: Show balance, navigate to Deposit, Withdraw, or ShowTransaction
    }
}
