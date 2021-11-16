package com.revature.Bank_App.Screen;

import com.revature.Bank_App.Service.UserService;
import com.revature.Bank_App.util.ScreenRouter;
import java.io.BufferedReader;
import static com.revature.Bank_App.util.AppState.AppStopping;

public class WelcomeScreen extends Screen{
    private UserService userService;
    //WelcomeScreen Constructor
    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter screenRouter, UserService userService) {
        super("Welcome Screen","welcome", consoleReader, screenRouter);
        this.userService=userService;
    }

    /*
        Welcome Screen guides user to make selection: go to LoginScreen, RegisterScreen, or simply Exit
     */
    @Override
    public void render() throws Exception {
        System.out.println("Welcome to the Bank App! Please make selections\n"+
                "1) Login\n"+
                "2) Register\n"+
                "3) Exits\n");
        System.out.print(">");
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
                break;
            case "throw exception":
                throw new RuntimeException();
            default:
                System.out.println("The user made an invalid selection");

        }
    }
}
