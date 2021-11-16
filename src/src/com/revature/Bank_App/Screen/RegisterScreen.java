package com.revature.Bank_App.Screen;

import com.revature.Bank_App.Exceptions.DataPersistenceException;
import com.revature.Bank_App.Exceptions.InvalidRequestException;
import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.ObjectModel.RegisterUser;
import com.revature.Bank_App.Service.UserService;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisterScreen extends Screen {
    private UserService userService;


    //RegisterScreen constructor
    public RegisterScreen(BufferedReader consoleReader, ScreenRouter screenRouter, UserService userService) {
        super("Register Screen", "register", consoleReader, screenRouter);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to New User Registration");
        System.out.println("Type in you information to register");

        //Taking User Info
        System.out.println("What's your first name?");
        String firstname = consoleReader.readLine();
        System.out.println("What's your last name?");
        String lastname = consoleReader.readLine();
        System.out.println("What's your Email address?");
        String email = consoleReader.readLine();
        System.out.println("Type in your username?");
        String username = consoleReader.readLine();
        System.out.println("Type in your password");
        String password = consoleReader.readLine();
        System.out.println("Please retype your password");
        String re_password = consoleReader.readLine();


        //System.out.println("Second password does not match the first!");
        RegisterUser tempUser = new RegisterUser(firstname, lastname, email, username, password, re_password);
        //System.out.println(tempUser.getFirstname()+tempUser.getLastname()+tempUser.getEmail()+tempUser.getUsername()+tempUser.getPassword());

        try {
            userService.RegisterNewUser(tempUser);
            screenRouter.navigate("dashboard");

        } catch (InvalidRequestException | DataPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
