package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class DepositScreen extends Screen{

    //DepositScreen Constructor
    public DepositScreen(String screenName, String routingString, BufferedReader consoleReader, ScreenRouter screenRouter) {
        super(screenName, routingString, consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Deposit!");
        //TODO: implement Deposit feature
    }
}
