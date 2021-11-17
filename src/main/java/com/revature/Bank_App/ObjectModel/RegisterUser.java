package com.revature.Bank_App.ObjectModel;

//Child class of AppUser for holding 2n password typed in
public class RegisterUser extends AppUser {
    private String repass;

    public RegisterUser(String firstName, String lastName, String email, String username, String password,String repass) {
        super(firstName, lastName, email, username, password);
        this.repass=repass;
    }

    //Getters for the 2nd time Password
    public String getRepass() {return repass;}
}
