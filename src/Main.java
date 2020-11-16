import com.mitrais.atm.model.Account;
import com.mitrais.atm.util.DataValidation;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        boolean loggedIn = false;
        welcomeScreen(loggedIn);
    }

    private static void welcomeScreen(boolean loggedIn) {
        Scanner scanner = new Scanner(System.in);

        String errorMessage = null;
        DataValidation validation = new DataValidation();

        Map<String,Object> res;

        System.out.println("======================================");
        System.out.println("=====Welcome to ATM Simulation v1=====");
        do {
            System.out.println("=============Please login=============");
            System.out.print("Enter Account Number : ");
            String accNumber = scanner.nextLine();
            System.out.print("Enter PIN : ");
            String accPin = scanner.nextLine();
            res = validation.checkLoginCredential(accNumber, accPin);
            loggedIn = (Boolean) res.get("isLoggedIn");
            if(res.get("errorMessage") != null) {
                errorMessage = res.get("errorMessage").toString();
                System.out.println("Error : "+errorMessage);
            } else {
                Account account = (Account) res.get("accountData");
                transactionScreen(account);
            }
        }
        while (!loggedIn);
    }

    public static void transactionScreen(Account account) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {

            System.out.println("=====Transaction Screen=====");
            System.out.println("1. Withdraw");
            System.out.println("2. Fund Transfer");
            System.out.println("3. Exit");
            System.out.print("Please choose option[3]: ");
            choice = scanner.nextLine();

            System.out.println("choice : "+choice);
        }
        while (!choice.equalsIgnoreCase("3") || choice.equals(""));
        welcomeScreen(false);

    }
}
