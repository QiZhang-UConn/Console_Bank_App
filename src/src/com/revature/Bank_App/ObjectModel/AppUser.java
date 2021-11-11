package com.revature.Bank_App.ObjectModel;

public class AppUser {
    private String id;
    private String firstname;
    private String lastname;
    private String Email;
    private String username;
    private String password;
    private Double balance;



    //Constructor takes userinfo
    public AppUser(String firstName, String lastName, String email, String username, String password) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.Email = email;
        this.username = username;
        this.password = password;
    }



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

    //set AppUser Instance balance
    //TODO: Need to create an Account class, set balance should not exist in final version
    public void setBalance(Double balance) {
        this.balance = balance;
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

    //AppUser instance return account balance
    //TODO: Need an new Class Account, getBalance() should not exist in final
    public Double getBalance(){
        return this.balance;
    }

}
