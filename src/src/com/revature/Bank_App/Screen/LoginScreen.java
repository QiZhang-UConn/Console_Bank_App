package com.revature.Bank_App.Screen;

import com.revature.Bank_App.Exceptions.DataPersistenceException;
import com.revature.Bank_App.Exceptions.InvalidRequestException;
import com.revature.Bank_App.Service.UserService;
import com.revature.Bank_App.util.ScreenRouter;
import java.io.BufferedReader;

public class LoginScreen extends Screen{
    UserService userService=new UserService();
    //LoginScreen constructor
    public LoginScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Register Screen","register", consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome Back Please enter your Username and password");
        System.out.println("Username: ");
        String username=consoleReader.readLine();
        System.out.println("Password: ");
        String password=consoleReader.readLine();

        try{
            boolean isLogin=userService.UserLogin(username,password);
            if(isLogin) System.out.println("Welcome Back Bank App User");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
