package com.revature.Bank_App.util;

import com.revature.Bank_App.util.ConnectionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTestSuite {

    @Test//Connection Test
    public void test_getConnection_returnsValidConnection_givenProvidedCredentials() {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            Assert.assertNotNull(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}