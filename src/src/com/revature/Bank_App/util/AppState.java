package com.revature.Bank_App.util;

import com.revature.Bank_App.Screen.DashboardScreen;
import com.revature.Bank_App.Screen.LoginScreen;
import com.revature.Bank_App.Screen.RegisterScreen;
import com.revature.Bank_App.Screen.WelcomeScreen;

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
    private static boolean isAuthenticated;//For the purpose to access Dashboard and other private screens
    private ScreenRouter availableScreens;


    //       _________App condition variable control______________
    //App Started and is running
    private void AppRunning(){isRunning=true;}
    //User decided to exit
    public static void AppStopping(){isRunning=false;}
    //User logged in
    private void userAuthenticated(){isAuthenticated=true;}


    //Constructor of AppState
    public AppState(){
        //input reader pass down to every screen for convenience
        BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in));
        //Once AppState is instantiated, means someone is using the app
        AppRunning();
        //initiating AppState must be before login, only Welcome, login, register can be accessed, maybe dashboard
        availableScreens=new ScreenRouter();
        availableScreens.addScreen(
                new WelcomeScreen(consoleReader,availableScreens));
        availableScreens.addScreen(
                new LoginScreen(consoleReader,availableScreens));
        availableScreens.addScreen(
                new RegisterScreen(consoleReader,availableScreens));
        availableScreens.addScreen(
                new DashboardScreen(consoleReader,availableScreens));
    }


    public void initialState(){
        try {
            while(isRunning) availableScreens.navigate("welcome");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
