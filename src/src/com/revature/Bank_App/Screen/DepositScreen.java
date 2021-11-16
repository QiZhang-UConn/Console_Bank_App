package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class DepositScreen extends Screen{

    //DepositScreen Constructor
    public DepositScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Deposit Screen", "deposit", consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Deposit!");
        //TODO: implement Deposit feature
    }
}
