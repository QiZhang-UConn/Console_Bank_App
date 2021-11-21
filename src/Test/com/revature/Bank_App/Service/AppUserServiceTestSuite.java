package com.revature.Bank_App.Service;

import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.Service.AppUserServiceTestSuite;
import com.revature.Bank_App.ObjectModel.RegisterUser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AppUserServiceTestSuite {
    UserService sut;


    @Before//Instantiate new sut for every test, so result may not cross-contaminate
    public void TestStart(){
        sut=new UserService();
    }

    @After//Clean up sut so result will not last to next test
    public void TestEnd(){
        sut=null;
    }

    @Test
    public void Test_isRegistrationValid(){
        RegisterUser invalidUser = new RegisterUser("valid", "valid", "valid", "valid", "valid","invalid");
        RegisterUser validUser = new RegisterUser("valid", "valid", "valid", "valid", "valid","valid");

        boolean test_invalid=sut.isRegistrationValid(invalidUser);
        boolean test_valid=sut.isRegistrationValid(validUser);

        Assert.assertTrue("Expected user to be considered false.", test_valid);
        Assert.assertFalse("Expected user to be considered false.",test_invalid);
    }
}
