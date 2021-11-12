package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;
import java.io.BufferedReader;

public class WelcomScreen extends Screen{

    //WelcomeScreen Constructor
    public WelcomScreen(String screenName, String routingString, BufferedReader consoleReader, ScreenRouter screenRouter) {
        super(screenName, routingString, consoleReader, screenRouter);
    }

    /*
        Welcome Screen guides user to make selection either go to LoginScreen, RegisterScreen, or simply Exit
     */
    @Override
    public void render() throws Exception {
        System.out.println("Welcome to the Bank App! Please make selections\n"+
                "1) Login\n"+
                "2) Register\n"+
                "3) Exits\n");
    }
}
