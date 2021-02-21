package com.mitrais.atm.view;

import com.mitrais.atm.model.Account;
import com.mitrais.atm.service.TransactionService;

import java.util.List;
import java.util.Scanner;

public class WithdrawScreen implements Screen{

    Account account = null;
    List<Account> accounts = null;
    TransactionService transactionService = new TransactionService();

    public WithdrawScreen(Account account, List<Account> accounts) {
        this.account = account;
        this.accounts = accounts;
    }

    @Override
    public void showScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====Withdraw Screen=====");
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.print("Please choose option[5]: ");
        String choice = scanner.nextLine();

        if(choice.equalsIgnoreCase("1")) {
            transactionService.processWithdraw(10, account, accounts);
        }else if(choice.equalsIgnoreCase("2")){
            transactionService.processWithdraw(50, account, accounts);
        }else if(choice.equalsIgnoreCase("3")){
            transactionService.processWithdraw(100, account, accounts);
        }else if(choice.equalsIgnoreCase("4")){
            OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen(account, accounts);
            otherWithdrawScreen.showScreen();
        }
        else if(choice.equalsIgnoreCase("5")){
            TransactionScreen transactionScreen = new TransactionScreen(account, accounts);
            transactionScreen.showScreen();
        }
        else if(!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") ||
                choice.equalsIgnoreCase("3") ||
                choice.equalsIgnoreCase("4") ||
                choice.equalsIgnoreCase("5")) && !choice.isEmpty()) {
            this.showScreen();
        }else {
            TransactionScreen transactionScreen = new TransactionScreen(account, accounts);
            transactionScreen.showScreen();
        }
    }
}