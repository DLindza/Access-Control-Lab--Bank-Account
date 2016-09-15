package lindsay.devon.AccessControlLabBankAccount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by devonlindsay on 9/14/16.
 */
public class Bank {
Account myAccount = new Account();
Account secondaryAccount = new Account();

    public void welcome() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Welcome to Devon's Bank!");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        welcomeMenu();
    }

    public void welcomeMenu() {
        while (true) {

            System.out.println("What would you like to do today?");
            System.out.println(" [1] Deposit Money [2] Make a Withdrawal [3] TransferFunds [4] Get transaction history [5] Get Available Balance [6] Exit");
            Scanner scanner1 = new Scanner(System.in);
            int menuChoice = scanner1.nextInt();
            if (menuChoice == 6) {
                System.out.println("Thank you for banking with Devon today!");
                break;
            } else {
                welcomeMenuChoice(menuChoice);
            }
        }
    }

    public void welcomeMenuChoice(int input) {

        switch (input) {
            case 1:
                myAccount.credit();
                break;
            case 2:
                myAccount.debit();
                break;
            case 3:
                myAccount.transferFunds(secondaryAccount);
                break;
            case 4:
                myAccount.printHistory();
                break;
            case 5:
                myAccount.getBalance();
        }
    }

}
