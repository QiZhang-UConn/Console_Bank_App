package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;
import java.io.BufferedReader;
import java.text.DecimalFormat;

public abstract class Screen {
    /*
        abstracted Screen class specifying Screen's property and behavior
        every screen needs to specify a screenName, a routingString.
        For convenience a bufferedReader will pass by to read user input
        and a ScreenRouter is provided for future navigation purpose
     */
    protected String screenName;
    protected String routingString;
    protected BufferedReader consoleReader;
    protected ScreenRouter screenRouter;
    protected final DecimalFormat df=new DecimalFormat("0.00");


    //constructor for a Screen
    public Screen(String screenName, String routingString, BufferedReader consoleReader, ScreenRouter screenRouter) {
        this.screenName = screenName;
        this.routingString = routingString;
        this.consoleReader = consoleReader;
        this.screenRouter = screenRouter;
    }


    //in the case you want to know what the current screen is
    public final String getScreenName(){return screenName;}

    //return routingString for Routing purpose
    public final String getRoute(){return routingString;}

    //finally, screen will pop up and provide functionality
    public abstract void render()throws Exception;

}
