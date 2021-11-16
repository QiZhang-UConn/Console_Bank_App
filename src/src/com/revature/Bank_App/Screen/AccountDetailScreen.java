package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class AccountDetailScreen extends Screen{
    public AccountDetailScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Account Detail Screen","detail", consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("detail");
        //TODO: implement show account detail method
    }
}
