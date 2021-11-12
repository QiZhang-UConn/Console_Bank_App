package com.revature.Bank_App.Screen;

import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.util.ConnectionFactory;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class RegisterScreen extends Screen{

    //RegisterScreen constructor
    public RegisterScreen(String screenName, String routingString, BufferedReader consoleReader, ScreenRouter screenRouter) {
        super(screenName, routingString, consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Register");
        //TODO: implement Registration function
        //TODO: implement Login Function
        System.out.println("The user selected Register");
        System.out.println("Please provide us with some basic information.");
        System.out.print("First name: ");
        String firstName = consoleReader.readLine();

        System.out.print("Last name: ");
        String lastName = consoleReader.readLine();

        System.out.print("Email: ");
        String email = consoleReader.readLine();

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        System.out.printf("Provided user first and last name: { \"firstName\": %s, \"lastName\": %s}\n", firstName, lastName);

        AppUser newUser = new AppUser(firstName, lastName, email, username, password);
        newUser.setId("11111");

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            newUser.setId(UUID.randomUUID().toString());

            String sql = "insert into bank_app_user (id, firstname, lastname, email, username, password) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getId());
            pstmt.setString(2, newUser.getFirstname());
            pstmt.setString(3, newUser.getLastname());
            pstmt.setString(4, newUser.getEmail());
            pstmt.setString(5, newUser.getUsername());
            pstmt.setString(6, newUser.getPassword());

            int rowsInserted = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
