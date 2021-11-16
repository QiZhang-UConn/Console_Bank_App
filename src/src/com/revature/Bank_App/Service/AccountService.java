package com.revature.Bank_App.Service;

import com.revature.Bank_App.DAO.AccountDao;
import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.util.LinkedList;
import sun.awt.image.ImageWatched;

import java.util.UUID;

/*
    This is a general purpose helper class for managing
*/
public class AccountService {
    private AccountDao accountDao;
    private UserService userService;

    public AccountService(UserService userService, AccountDao accountDao){
        this.userService=userService;
        this.accountDao=accountDao;
    }

    public int getAccountNum() {return userService.howManyAccount();}



    //_________________Opening Account Information Export_______________
    public LinkedList<String> exportMissingAccount(){
        LinkedList<String> allAccounts=new LinkedList<>();
        LinkedList<String> current=currentAccount();
        if(!current.contains("checking")) allAccounts.add("checking");
        if(!current.contains("saving"))allAccounts.add("saving");
        if(!current.contains("investment"))allAccounts.add("investment");
        return allAccounts;
    }
    public LinkedList<String> currentAccount(){
        LinkedList<String> accountList=new LinkedList<>();
        LinkedList<Account> accounts=getAccounts();
        for(int i=0; i<getAccountNum();i++){
            accountList.add(accounts.get(i).getAccountName());
        }
        return accountList;
    }
    public LinkedList<Account> getAccounts(){
        return userService.exportAccount();
    }


    public void createAccount(String accountType) {
        int type_id;
        switch (accountType){
            case "checking":
                type_id=1;
                break;
            case "saving":
                type_id=2;
                break;
            case "investment":
                type_id=3;
                break;
        }
        Account tempAccount=new Account(accountType,UUID.randomUUID().toString(),userService.getSessionUsername());
        Account newAccount=accountDao.save(tempAccount);
        if(newAccount!=null){
            System.out.println(accountType+" account created successfully");
            userService.UserAddAccount(newAccount);
        }

    }
}
