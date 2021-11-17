package com.revature.Bank_App.Service;

import com.revature.Bank_App.DAO.AppUserDao;
import com.revature.Bank_App.Exceptions.DataPersistenceException;
import com.revature.Bank_App.Exceptions.InvalidRequestException;
import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.ObjectModel.RegisterUser;
import com.revature.Bank_App.util.LinkedList;

import static com.revature.Bank_App.util.color.*;

/*
    This is a general purpose service class for AppUser, specialized for:
        1.verifying valid input of registration,
        2.verifying password matching login
        3.main user of uerDAO
        4.Hold a sessionUser which is an authenticated user
*/
public class UserService {
    private AppUser sessionUser;//UserService takes in a temp AppUser and verify info
    private AppUserDao appUserDao=new AppUserDao();



    //userService Constructor
    public UserService(AppUser sessionUser){this.sessionUser=sessionUser;}
    public UserService(AppUserDao userDao){appUserDao=userDao;}
    public UserService(){}


    //Indicate if user authenticated
    public boolean isSessionExit(){return !(sessionUser==null);}
    public void sessionLogout(){sessionUser=null;}
    public AppUser exportSessionUser(){return sessionUser;}


    //Helper for to manipulate sessionUser data without directly passing sessionUser
    public int howManyAccount(){ return sessionUser.HowManyAccount();}
    public LinkedList<Account> exportAccount(){return sessionUser.getAccountList();}
    public String getSessionUsername(){return sessionUser.getUsername();}
    public boolean UserAddAccount(Account account){
        sessionUser.addAccount(account);
        return true;
    }




    //Helper method checks if provided user info is null or empty string, prevent high cost invalid query
    public boolean isRegistrationValid(RegisterUser tempUser){
            //Check if 2 password match
            if(!tempUser.getPassword().equals(tempUser.getRepass())){
                System.out.println(ANSI_YELLOW+"Two password does not match"+ANSI_RESET);
                return false;
            }
            //check if input is null or empty String
            if(tempUser.getFirstname()==null||tempUser.getFirstname().trim().equals("")) return false;
            if(tempUser.getLastname()==null||tempUser.getLastname().trim().equals("")) return false;
            if(tempUser.getEmail()==null||tempUser.getEmail().trim().equals("")) return false;
            if(tempUser.getUsername()==null||tempUser.getUsername().trim().equals("")) return false;
            if(tempUser.getPassword()==null||tempUser.getPassword().trim().equals("")) return false;
        return true;
    }



    //User Provided information ready for register
    public boolean RegisterNewUser(RegisterUser user) throws DataPersistenceException {
        //First check if input is valid
        if (!isRegistrationValid(user))
            throw new InvalidRequestException(ANSI_RED+"Invalid User Information Provided"+ANSI_RESET);
        //If Username founded raise Exception to notice user username occupied
        if (!(appUserDao.findByUsername(user.getUsername()) == null))
            throw new DataPersistenceException(ANSI_RED+"Username occupied, please input another one"+ANSI_RESET);
        //If Email founded prompt user to re-enter info
        if (!(appUserDao.findByEmail(user.getEmail()) == null))
            throw new DataPersistenceException(ANSI_RED+"Email occupied, please input another one"+ANSI_RESET);
        //Otherwise, save the user info to database
        sessionUser = appUserDao.save(user);
        //Raise exception if data doesn't save correctly
        if (sessionUser == null) {
            throw new DataPersistenceException(ANSI_RED+"The user could not be persisted to the datasource!"+ANSI_RESET);
        }
        return true;
    }



    //User Login
    public AppUser UserLogin(String username, String password) throws DataPersistenceException {
        if(username==null||username.trim().equals("")) return null;
        if(username==null||username.trim().equals("")) return null;
        AppUser tempUser=appUserDao.findByUsername(username);
        if(tempUser==null) {
            throw new DataPersistenceException("Username Not found");
        }
        if (tempUser.getPassword().equals(password)){
            sessionUser=tempUser;
            return sessionUser;
        }
        return null;
    }

}
