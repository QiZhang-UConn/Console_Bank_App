package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisterScreen extends Screen{

    //RegisterScreen constructor
    public RegisterScreen(String screenName, String routingString, BufferedReader consoleReader, ScreenRouter screenRouter) {
        super(screenName, routingString, consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Register");
        //TODO: implement Registration function
    }
}
