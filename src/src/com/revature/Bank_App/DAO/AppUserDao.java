package com.revature.Bank_App.DAO;

import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.util.ConnectionFactory;
import com.revature.Bank_App.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
    Data Access Object(DAO) class, used for creating, reading, updating, and deleting data entry
*/
public class AppUserDao implements CrudDAO{




    //___________________________Find User from database____________________________
    public AppUser findByUsername(String username){
        try(Connection conn= ConnectionFactory.getInstance().getConnection()){
            //Prepare SQL Query Statement
            String sql_statement="select * from bank_app_user where username=?";
            PreparedStatement pre_statement= conn.prepareStatement(sql_statement);
            pre_statement.setString(1,username);
            //Execute and get AppUser info from database
            ResultSet result=pre_statement.executeQuery();
            //if user exists, obtain user info and return
            if(result.next()){
                AppUser queryUser=new AppUser();
                queryUser.setUsername(result.getString("username"));
                queryUser.setPassword(result.getString("password"));
                queryUser.setFirstname(result.getString("firstname"));
                queryUser.setLastname(result.getString("lastname"));
                queryUser.setEmail((result.getString("email")));
                return queryUser;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public AppUser findByEmail(String email){
        try(Connection conn=ConnectionFactory.getInstance().getConnection()){
            //prepare sql statement
            String sql_statement="select * from bank_app_user where email=?";
            PreparedStatement pre_Statement=conn.prepareStatement(sql_statement);
            pre_Statement.setString(1,email);
            //Execute and obtain user info
            ResultSet result=pre_Statement.executeQuery();
            //If AppUser exists obtain user info
            if(result.next()){
                AppUser queryUser=new AppUser();
                queryUser.setUsername(result.getString("username"));
                queryUser.setPassword(result.getString("password"));
                queryUser.setFirstname(result.getString("firstname"));
                queryUser.setLastname(result.getString("lastname"));
                queryUser.setEmail((result.getString("email")));
                return queryUser;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public AppUser findByPassword(String email){
        return null;
    }

    @Override
    public Object save(Object newObj) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public boolean update(Object updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
