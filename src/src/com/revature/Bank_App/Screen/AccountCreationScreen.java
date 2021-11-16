package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class AccountCreationScreen extends Screen{
    public AccountCreationScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Create Account Screen", "create", consoleReader, screenRouter);

    }

    @Override
    public void render() throws Exception {
        System.out.println("create");
        //TODO: implement account creation screen
    }
}
