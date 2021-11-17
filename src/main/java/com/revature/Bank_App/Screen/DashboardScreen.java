package com.revature.Bank_App.Screen;

import com.revature.Bank_App.Service.AccountService;
import com.revature.Bank_App.Service.UserService;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.Bank_App.util.color.*;

/*
    Screen served as a welcome navigation panel for user private actions
*/
public class DashboardScreen extends Screen{
    private final UserService userService;
    private AccountService accountService;

    //DashboardScreen Constructor
    public DashboardScreen(BufferedReader consoleReader, ScreenRouter screenRouter, UserService userService) {
        super("Dashboard Screen","dashboard", consoleReader, screenRouter);
        //Takes over the session user by enclosed userService function
        this.userService=userService;
        //Once Dashboard Instantiated, user allowed to access the private screens

    }

    @Override
    public void render() throws Exception {
        System.out.println(ANSI_BLUE+"Welcome to Dashboard!"+ANSI_RESET);
        while (userService.isSessionExit()) {
            System.out.println(ANSI_CYAN+"What do you want to do today?"+ANSI_RESET);
            System.out.println("1) Create an account\n" +
                    "2) Deposit money into an account\n" +
                    "3) Withdraw money from an account\n" +
                    "4) View Account balance\n" +//might be removed so shows directly in dashboard
                    //"5) View transaction of an account\n" +
                    "5) Transfer money between accounts\n" +
                    "6) Log Out");
            String userSelection = consoleReader.readLine();


            switch (userSelection) {
                case "1":
                    screenRouter.navigate("create");
                    break;
                case "2":
                    screenRouter.navigate("deposit");
                    break;
                case "3":
                    screenRouter.navigate("withdraw");
                    break;
                case "4":
                    screenRouter.navigate("detail");
                    break;
//                case "5":
//                    screenRouter.navigate("transaction");
//                    break;
                case "5":
                    screenRouter.navigate("transfer");
                    break;
                case "6":
                    System.out.println("See You Later~");
                    userService.sessionLogout();
                    break;
                case "throw exception":
                    throw new RuntimeException();
                default:
                    System.out.println("The user made an invalid selection");

            }
        }
    }
}
