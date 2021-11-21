package com.revature.Bank_App.Service;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountUserTestSuite {
    AccountService sut;

    @Before//Instantiate new sut for every test, so result may not cross-contaminate
    public void TestStart(){
        sut=new AccountService();
    }

    @After//Clean up sut so result will not last to next test
    public void TestEnd(){
        sut=null;
    }

    @Test
    public void TestInputAmount(){
        double test_validMoney=sut.parseMoney("1000");
        double test_invalidMoney=sut.parseMoney("xx");

        Assert.assertEquals(1000.0,test_validMoney);
        Assert.assertEquals(-0.00,test_invalidMoney);
    }
}
