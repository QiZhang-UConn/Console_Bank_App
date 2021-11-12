package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;
import java.io.BufferedReader;
import static com.revature.Bank_App.util.AppState.AppStopping;

public class WelcomeScreen extends Screen{

    //WelcomeScreen Constructor
    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Welcome Screen","welcome", consoleReader, screenRouter);
    }

    /*
        Welcome Screen guides user to make selection either go to LoginScreen, RegisterScreen, or simply Exit
     */
    @Override
    public void render() throws Exception {
        System.out.println("Welcome to the Bank App! Please make selections\n"+
                "1) Login\n"+
                "2) Register\n"+
                "3) Exits\n"+
                "> ");
        String userDecision=consoleReader.readLine();
        switch (userDecision){
            case "1":
                screenRouter.navigate("login");
                break;
            case "2":
                screenRouter.navigate("register");
                break;
            case "3":
                System.out.println("Bye~");
                AppStopping();
            case "throw exception":
                throw new RuntimeException();
            default:
                System.out.println("The user made an invalid selection");

        }
    }
}
