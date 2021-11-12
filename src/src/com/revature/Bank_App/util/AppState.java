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
        BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in));
        AppRunning();//Once AppState is instantiated, means someone is using the app
        availableScreens=new ScreenRouter();
        availableScreens.addScreen(
                new WelcomeScreen("Welcome Screen","welcome",consoleReader,availableScreens));
        availableScreens.addScreen(
                new LoginScreen("Login Screen","login",consoleReader,availableScreens));
        availableScreens.addScreen(
                new RegisterScreen("Register Screen","register",consoleReader,availableScreens));
        availableScreens.addScreen(
                new DashboardScreen("Dashboard Screen","dashboard",consoleReader,availableScreens));
    }

    public void initialState(){
        while(isRunning) {
            try {
                availableScreens.navigate("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
