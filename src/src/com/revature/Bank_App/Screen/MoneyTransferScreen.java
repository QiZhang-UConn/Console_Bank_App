package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class MoneyTransferScreen extends Screen{
    public MoneyTransferScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Money Transfer Screen", "transfer", consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("transfer");
        //TODO: implement Transfer between accounts method
    }
}
