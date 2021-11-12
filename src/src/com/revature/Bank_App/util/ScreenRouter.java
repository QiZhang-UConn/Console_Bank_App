package com.revature.Bank_App.util;

import com.revature.Bank_App.Screen.Screen;

/*
    a screen router class holds and manipulates a linked-list to store different screens of functionality
 */
public class ScreenRouter {
    private LinkedList<Screen> screenList;//initially null

    //constructor for screenRouter, once instantiated create a list to store screens
    public ScreenRouter(){screenList=new LinkedList<Screen>();}

    //adding new screens to screenLists
    public void addScreen(Screen addingScreen){screenList.add(addingScreen);}

    //navigating to desired screen by taking the routing String keyword
    public void navigate(String routingString) throws Exception{
        for(int i=0; i<screenList.getSize(); i++){
            Screen currentScreen=screenList.get(i);
            if (currentScreen.getRoute()==routingString){
                currentScreen.render();
            }
        }

    }

}
