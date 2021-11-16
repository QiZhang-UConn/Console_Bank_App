package com.revature.Bank_App.util;

import com.revature.Bank_App.DAO.AccountDao;
import com.revature.Bank_App.DAO.AppUserDao;
import com.revature.Bank_App.Screen.*;
import com.revature.Bank_App.Service.AccountService;
import com.revature.Bank_App.Service.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
   AppState is a general purpose helper class that
    1. initialize a screenRouter for the sake of screen navigation
    2. guides user to the WelcomeScreen
    3. holds isRunning value to loop the Screen back to Welcome
    4. holds consoleReader for input purpose
   TODO:AppSate will hold a session instance which the authenticated user will be allowed to access Dashboard
*/
public class AppState {
    private static boolean isRunning;//we want to go back to welcome unless user exit
    //private static boolean isAuthenticated;//For the purpose to access Dashboard and other private screens
    private final ScreenRouter availableScreens;

    //       _________App condition variable control______________
    //App Started and is running
    public static void AppRunning(){isRunning=true;}
    //User decided to exit
    public static void AppStopping(){isRunning=false;}
    //User logged in



    //Constructor of AppState
    public AppState(){
        //input reader pass down to every screen for convenience
        BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in));
        //Once AppState is instantiated, means someone is using the app
        AppRunning();
        AppUserDao userDAO = new AppUserDao();
        UserService userService = new UserService(userDAO);
        AccountDao accountDao=new AccountDao();
        AccountService accountService=new AccountService(userService,accountDao);
        //initiating AppState must be before login, only Welcome, login, register can be accessed, maybe dashboard
        availableScreens=new ScreenRouter();
        availableScreens.addScreen(new WelcomeScreen(consoleReader,availableScreens,userService));
        availableScreens.addScreen(new LoginScreen(consoleReader,availableScreens,userService));
        availableScreens.addScreen(new RegisterScreen(consoleReader,availableScreens,userService));
        availableScreens.addScreen(new DashboardScreen(consoleReader,availableScreens,userService));
        availableScreens.addScreen(new AccountCreationScreen(consoleReader,availableScreens,accountService));
        availableScreens.addScreen(new DepositScreen(consoleReader,availableScreens));
        availableScreens.addScreen(new WithdrawScreen(consoleReader,availableScreens));
        availableScreens.addScreen(new AccountDetailScreen(consoleReader,availableScreens,accountService));
        availableScreens.addScreen(new TransactionScreen(consoleReader,availableScreens));
        availableScreens.addScreen(new MoneyTransferScreen(consoleReader,availableScreens));

    }


    public void initialState(){
        try {
            while(isRunning){
                availableScreens.navigate("welcome");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
