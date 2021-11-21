package com.revature.Bank_App.Service;

import com.revature.Bank_App.DAO.AccountDao;
import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.util.LinkedList;

import java.text.DecimalFormat;
import java.util.UUID;

import static com.revature.Bank_App.util.color.ANSI_RESET;
import static com.revature.Bank_App.util.color.ANSI_YELLOW;

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
    public AccountService(){}

    public int getAccountNum() {return userService.howManyAccount();}

    public  double parseMoney(String amount){
        double output;
        try{
            output=Double.parseDouble(amount);
            return output;
        }catch (NumberFormatException| NullPointerException e){
            System.out.println(ANSI_YELLOW+"Invalid format please re-enter the amount"+ANSI_RESET);;
        }
        return -0.00;
    }
    public boolean isDecline(Account account, double amount){
        return amount>account.getAccountBalance();
    }

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

    public void deposit(Account account, String amount) {
        double moneyAmount=parseMoney(amount);
        if(moneyAmount==-0.00){
            System.out.println(ANSI_YELLOW+"Invalid amount was given"+ANSI_RESET);
        }
        account.setAccountBalance(account.getAccountBalance()+moneyAmount);
        accountDao.update(account);
    }
    public void withdraw(Account account,String amount){
        double moneyAmount=parseMoney(amount);
        if(moneyAmount==-0.00){
            System.out.println(ANSI_YELLOW+"Invalid amount was given"+ANSI_RESET);
        }
        if(isDecline(account,moneyAmount)){
            System.out.println(ANSI_YELLOW+"Declined, balance not enough"+ANSI_RESET);
        }
        else{
            account.setAccountBalance(account.getAccountBalance()-moneyAmount);
            accountDao.update(account);
        }
    }
    public void transfer(Account fromAccount, Account toAccount, String amount){
        double moneyAmount=parseMoney(amount);
        if(moneyAmount==-0.00){
            System.out.println(ANSI_YELLOW+"Invalid amount was given"+ANSI_RESET);
        }
        if(isDecline(fromAccount,moneyAmount)){
            System.out.println(ANSI_YELLOW+"Declined, balance not enough"+ANSI_RESET);
        }
        else{
            fromAccount.setAccountBalance(fromAccount.getAccountBalance()-moneyAmount);
            accountDao.update(fromAccount);
            toAccount.setAccountBalance(toAccount.getAccountBalance()+moneyAmount);
            accountDao.update(toAccount);
        }
    }
}
