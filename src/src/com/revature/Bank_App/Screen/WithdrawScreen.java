package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class WithdrawScreen extends Screen{

    //WithdrawScreen Constructor
    public WithdrawScreen(String screenName, String routingString, BufferedReader consoleReader, ScreenRouter screenRouter) {
        super(screenName, routingString, consoleReader, screenRouter);
    }


    @Override
    public void render() throws Exception {
        System.out.println("Withdraw~");
        //TODO: implement withdraw feature
    }
}
