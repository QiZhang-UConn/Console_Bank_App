package com.revature.Bank_App.Screen;

import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.Bank_App.util.AppState.AppStopping;

public class DashboardScreen extends Screen{
    private final AppUser sessionUser;

    //DashboardScreen Constructor
    public DashboardScreen(BufferedReader consoleReader, ScreenRouter screenRouter, AppUser sessionUser) {
        super("Dashboard Screen","dashboard", consoleReader, screenRouter);
        //Takes over the session user
        this.sessionUser=sessionUser;
        //Once Dashboard Instantiated, user allowed to access the private screens
        screenRouter.addScreen(new DashboardScreen(consoleReader,screenRouter,sessionUser));
        screenRouter.addScreen(new DashboardScreen(consoleReader,screenRouter,sessionUser));
        screenRouter.addScreen(new DashboardScreen(consoleReader,screenRouter,sessionUser));
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to Dashboard!");
        System.out.println("What do you want to do today?");
        System.out.println("1) Create an account\n"+
                           "2) Deposit money into an account\n"+
                           "3) Withdraw money from an account\n"+
                           "4) View Account balance\n"+//might be removed so shows directly in dashboard
                           "5) View transaction of an account\n"+
                           "6) Transfer money between accounts\n"+
                           "7) Exit");
        String userSelection=consoleReader.readLine();
        switch (userSelection){
            case "1":
                //screenRouter.navigate("login");
                break;
            case "2":
                //screenRouter.navigate("register");
                break;
            case "3":
                //System.out.println("Bye~");
                //AppStopping();
            case "throw exception":
                throw new RuntimeException();
            default:
                System.out.println("The user made an invalid selection");

        }
    }
}
