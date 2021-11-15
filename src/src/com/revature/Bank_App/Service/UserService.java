package com.revature.Bank_App.Service;

import com.revature.Bank_App.ObjectModel.AppUser;

/*
    This is a general purpose service app, specialized for:
        1.verifying valid input of registration,
        2.verifying password matching login
        3.main user of uerDAO
*/
public class UserService {
    private AppUser sessionUser;//UserService takes in a temp AppUser and verify info

    //userService Constructor
    public UserService(){}



    public boolean isRegistrationValid(AppUser tempUser, String re_password){
        if(!tempUser.getPassword().equals(re_password))
            return false;//Check if 2 password match
        else{
            //check if input is null or empty String
            if(tempUser.getFirstname()==null||tempUser.getFirstname().trim().equals("")) return false;
            if(tempUser.getLastname()==null||tempUser.getLastname().trim().equals("")) return false;
            if(tempUser.getEmail()==null||tempUser.getEmail().trim().equals("")) return false;
            if(tempUser.getUsername()==null||tempUser.getUsername().trim().equals("")) return false;
            if(tempUser.getPassword()==null||tempUser.getPassword().trim().equals("")) return false;
        }
        return true;
    }

    //TODO: implement reusable user service functionality makes thing easier
    //TODO: register user
    //TODO: verifying authentication
    //TODO: session manipulation
}
