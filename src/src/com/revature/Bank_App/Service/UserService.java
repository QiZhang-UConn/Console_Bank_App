package com.revature.Bank_App.Service;

import com.revature.Bank_App.DAO.AppUserDao;
import com.revature.Bank_App.Exceptions.InvalidRequestException;
import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.ObjectModel.RegisterUser;

/*
    This is a general purpose service app, specialized for:
        1.verifying valid input of registration,
        2.verifying password matching login
        3.main user of uerDAO
*/
public class UserService {
    private AppUser sessionUser;//UserService takes in a temp AppUser and verify info
    private AppUserDao appUserDao=new AppUserDao();

    //userService Constructor
    public UserService(){}

    //Helper method checks if provided user info is null or empty string, prevent high cost invalid query
    public boolean isRegistrationValid(RegisterUser tempUser){
            //Check if 2 password match
            if(!tempUser.getPassword().equals(tempUser.getRepass())) return false;
            //check if input is null or empty String
            if(tempUser.getFirstname()==null||tempUser.getFirstname().trim().equals("")) return false;
            if(tempUser.getLastname()==null||tempUser.getLastname().trim().equals("")) return false;
            if(tempUser.getEmail()==null||tempUser.getEmail().trim().equals("")) return false;
            if(tempUser.getUsername()==null||tempUser.getUsername().trim().equals("")) return false;
            if(tempUser.getPassword()==null||tempUser.getPassword().trim().equals("")) return false;
        return true;
    }

    //User Provided information ready for register
    public boolean RegisterNewUser(RegisterUser user) {
        //First check if input is valid
        if (!isRegistrationValid(user)) throw new InvalidRequestException("Invalid User Information Provided");
        //If Username founded raise Exception to notice user username occupied
        if (!(appUserDao.findByUsername(user.getUsername()) == null)) {
            if (!(appUserDao.findByEmail(user.getEmail()) == null)) {

            } else {

            }
            return false;
        }
        return true;
    }



    //TODO: implement reusable user service functionality makes thing easier
    //TODO: register user
    //TODO: verifying authentication
    //TODO: session manipulation
}
