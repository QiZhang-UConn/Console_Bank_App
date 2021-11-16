package com.revature.Bank_App.Screen;

import com.revature.Bank_App.DAO.AccountDao;
import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.Service.AccountService;
import com.revature.Bank_App.Service.UserService;
import com.revature.Bank_App.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.Bank_App.util.AppState.AppStopping;

/*
    Screen served as a welcome navigation panel for user private actions
*/
public class DashboardScreen extends Screen{
    private final UserService userService;
    private AccountService accountService;

    //DashboardScreen Constructor
    public DashboardScreen(BufferedReader consoleReader, ScreenRouter screenRouter, UserService userService) {
        super("Dashboard Screen","dashboard", consoleReader, screenRouter);
        //Takes over the session user by enclosed userService function
        this.userService=userService;
        AccountDao accountDao=new AccountDao();
        accountService=new AccountService(userService,accountDao);
        //Once Dashboard Instantiated, user allowed to access the private screens
        screenRouter.addScreen(new AccountCreationScreen(consoleReader,screenRouter,accountService));
        screenRouter.addScreen(new DepositScreen(consoleReader,screenRouter));
        screenRouter.addScreen(new WithdrawScreen(consoleReader,screenRouter));
        screenRouter.addScreen(new AccountDetailScreen(consoleReader,screenRouter,accountService));
        screenRouter.addScreen(new TransactionScreen(consoleReader,screenRouter));
        screenRouter.addScreen(new MoneyTransferScreen(consoleReader,screenRouter));
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to Dashboard!");
        while (userService.isSessionExit()) {
            System.out.println("What do you want to do today?");
            System.out.println("1) Create an account\n" +
                    "2) Deposit money into an account\n" +
                    "3) Withdraw money from an account\n" +
                    "4) View Account balance\n" +//might be removed so shows directly in dashboard
                    "5) View transaction of an account\n" +
                    "6) Transfer money between accounts\n" +
                    "7) Log Out");
            String userSelection = consoleReader.readLine();


            switch (userSelection) {
                case "1":
                    screenRouter.navigate("create");
                    break;
                case "2":
                    screenRouter.navigate("deposit");
                    break;
                case "3":
                    screenRouter.navigate("withdraw");
                    break;
                case "4":
                    screenRouter.navigate("detail");
                    break;
                case "5":
                    screenRouter.navigate("transaction");
                    break;
                case "6":
                    screenRouter.navigate("transfer");
                    break;
                case "7":
                    System.out.println("See You Later~");
                    userService.sessionLogout();
                    break;
                case "throw exception":
                    throw new RuntimeException();
                default:
                    System.out.println("The user made an invalid selection");

            }
        }
    }
}
