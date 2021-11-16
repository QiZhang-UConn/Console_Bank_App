package com.revature.Bank_App.DAO;

import com.revature.Bank_App.ObjectModel.Account;
import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.ObjectModel.RegisterUser;
import com.revature.Bank_App.util.ConnectionFactory;
import com.revature.Bank_App.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


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
                String sql_statement2="select * from accounts where username=?";
                PreparedStatement pre_statement2= conn.prepareStatement(sql_statement2);
                pre_statement2.setString(1, queryUser.getUsername());
                ResultSet result2=pre_statement2.executeQuery();
                while(result2.next()){
                    Account tempAccount=new Account();
                    tempAccount.setAccountNumber(result2.getString("account_id"));
                    tempAccount.setUsername(result2.getString("username"));
                    tempAccount.setAccountBalance(result2.getDouble("balance"));
                    int type=result2.getInt("type_id");
                    if(type==1) tempAccount.setAccountName("checking");
                    if(type==2) tempAccount.setAccountName("saving");
                    if(type==3) tempAccount.setAccountName("investment");
                    queryUser.addAccount(tempAccount);
                }
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
    public AppUser save(RegisterUser validUser){
        //Taking Child class, convert to App User
        AppUser newUser= new AppUser(validUser.getFirstname(),validUser.getLastname(),
                        validUser.getEmail(),validUser.getUsername(),validUser.getPassword());
        try(Connection conn=ConnectionFactory.getInstance().getConnection()){
            newUser.setId(UUID.randomUUID().toString());
            //prepare SQL statement
            String sql_statement=
                    "insert into bank_app_user (id, firstname, lastname, email, username, password) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre_statement=conn.prepareStatement(sql_statement);
            pre_statement.setString(1,newUser.getId());
            pre_statement.setString(2,newUser.getFirstname());
            pre_statement.setString(3,newUser.getLastname());
            pre_statement.setString(4,newUser.getEmail());
            pre_statement.setString(5,newUser.getUsername());
            pre_statement.setString(6,newUser.getPassword());
            //Execute statement and save
            pre_statement.execute();
            int rowsInserted = pre_statement.executeUpdate();
            if(rowsInserted!=0){
                return newUser;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

   // public AppUser findByPassword(String email){
  //      return null;
  //  }

    @Override//overriding method saving user info after registration
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
