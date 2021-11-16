package com.revature.Bank_App.ObjectModel;

import com.revature.Bank_App.util.LinkedList;

public class AppUser {
    private String id;
    private String firstname;
    private String lastname;
    private String Email;
    private String username;
    private String password;
    private LinkedList<Account> accounts=new LinkedList<>();



    //Constructor takes userinfo
    public AppUser(String firstName, String lastName, String email, String username, String password) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.Email = email;
        this.username = username;
        this.password = password;
    }
    //Overloaded version of AppUser Constructor for later use if data is not
    //manually provided which depend on runtime result of certain function like query
    public AppUser(){}

    //__________________Account List Section_____________
    public LinkedList<Account> exportAccountList(){return accounts;}
    public void addAccount(Account account){accounts.add(account);}




    //_____________Setters Section________________

    //set AppUser Instance id
    public void setId(String id) {
        this.id = id;
    }

    //set AppUser Instance firstname
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    //set AppUser Instance lastname
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //set AppUser Instance email
    public void setEmail(String email) {
        Email = email;
    }

    //set AppUser Instance username
    public void setUsername(String username) {
        this.username = username;
    }

    //set AppUser Instance password
    public void setPassword(String password) {
        this.password = password;
    }



    //__________Getters Section_____________
    //AppUser instance return id
    public String getId(){
        return this.id;
    }

    //AppUser instance return firstname
    public String getFirstname(){
        return this.firstname;
    }

    //AppUser instance return lastname
    public String getLastname(){
        return this.lastname;
    }

    //AppUser instance return email
    public String getEmail(){
        return this.Email;
    }

    //AppUser instance return username
    public String getUsername(){
        return this.username;
    }

    //AppUser instance return password
    public String getPassword(){
        return this.password;
    }

    public LinkedList<Account> getAccounts() {
        return accounts;
    }
}
