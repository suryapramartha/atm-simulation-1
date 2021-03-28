import com.mitrais.atm.model.Account;
import com.mitrais.atm.service.AccountService;
import com.mitrais.atm.service.AccountServiceImpl;
import com.mitrais.atm.view.WelcomeScreen;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static final String FILE_INPUT_PATH = "resources/ATM-accounts.csv";

    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountServiceImpl();

        String path = System.getProperty("file");
        if (path == null) {
            System.out.print("File path not provided, switch to default path configuration...");
            path = FILE_INPUT_PATH;
        }
        List<Account> accounts = accountService.loadAccountsFromCSV(path);
        accountService.setAccountList(accounts);
        Stream.of(accounts).forEach(System.out::println);
        do {
           WelcomeScreen welcomeScreen = new WelcomeScreen();
           welcomeScreen.showScreen();
        } while (true);
    }
}