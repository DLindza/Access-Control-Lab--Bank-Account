package lindsay.devon.AccessControlLabBankAccount;

import java.util.Scanner;

/**
 * Created by devonlindsay on 9/13/16.
 */
public class Account {
        // to print in color System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

   private double balance;
   private enum OverDraftProtection {ENABLED, DISABLED, AUTOMATICTRANSFER}
   private OverDraftProtection overDraftProtection;
   private boolean accountNotFrozen;
   private boolean transactionCompleted;
   private double accountBalance;
   private AccountHolder accountHolder;
   private InterestRate accountInterestRate;
   Scanner scanner = new Scanner(System.in);
   private enum Type {CHECKING, SAVINGS, INVESTMENT}
   private enum Status {OPEN, CLOSED, FROZEN}
   private double availableBalance;
   private double interestRate;
   private Type type;
   private Status status;
   private static double idNumber = 000;
   private static double lastIdNumber;


    Account (Type type ) {
        this.type = type;
        this.status = Status.OPEN;
        this.idNumber = ++lastIdNumber;
        this.accountBalance = 0;
        this.accountHolder = new AccountHolder();
        this.accountInterestRate = new InterestRate();
        // Interest Rate
        this.overDraftProtection = OverDraftProtection.ENABLED;
        this.accountNotFrozen = true;
        this.transactionCompleted = false;
    }



    public void transferFunds(Account secondaryAccount) {
        this.debit();
        secondaryAccount.credit();

    }

    public enum setStatus() {
        // todo set Status

    }


    public boolean creditTransactionCompleted() {
        if (credit()) {
            System.out.println("Your account balance has been updated.");
            System.out.println("Your new balance is: " + getBalance());
            //TODO create new transaction object type debit to transaction history array
            return true;
        } else {
            System.out.println("Sorry, your transaction did not go through");
            return false;
        }
    }
    public boolean debitTransactionCompleted() {
        if (debit()) {
            System.out.println("Your account balance has been updated.");
            System.out.println("Your new balance is: " + getBalance());
            //TODO create new transaction object type credit to transaction history array
            return true;
        } else {
            System.out.println("Sorry, your transaction did not go through.");
            return false;
        }
    }

    public boolean freezeCompleted() {
        if (freezeAccount()) {
            System.out.println("Account is now frozen");
            //TODO create new transaction object type credit to transaction history array
            return true;
        } else {
            System.out.println("Sorry, your transaction did not go through.");
            return false;
        }
    }

    public boolean credit() {
            System.out.println("How much would you like to deposit?");
            Scanner scanner = new Scanner(System.in);
            double userInput = scanner.nextDouble();

            if (accountNotFrozen) {
                this.balance = this.balance + userInput;
            } else {
                System.out.println("Your account is currently frozen and cannot be accessed.");
            }
            return false;
        }


        public boolean debit() {
            System.out.println("How much would you like to withdraw from your account?");
            Scanner scanner = new Scanner(System.in);
            double userInput = scanner.nextDouble();
            if (overDraftProtection.equals(OverDraftProtection.ENABLED)) {
                if ((userInput - this.balance) < 0) {
                    System.out.println("Your account does not have enough funds to support this transaction");
                    return false;
                }
            }
            if(accountNotFrozen) {
                this.balance = this.balance - userInput;
            } else {
                System.out.println("Your account is currently frozen and cannot be accessed.");
            }
            return false;
        }


        public boolean freezeAccount() {
            this.accountNotFrozen = false;
            //TODo add transaction object to transactionHistory[]
            return true;
        }

        public void overdraftProtectionOptions() {
            System.out.println("What would you like to do with Overdraft Protection?");
            System.out.println(" [1] ENABLE  [2] DISABLE  [3] SET UP AUTO TRANSFER FROM ANOTHER ACCOUNT");
            Scanner scanner = new Scanner(System.in);
            int setOverDraft = scanner.nextInt();
            setOverDraft(setOverDraft);
        }

        public void setOverDraft(int userInput) {
            switch (userInput) {
                case 1:
                    this.overDraftProtection = OverDraftProtection.ENABLED;
                    break;
                case 2:
                    this.overDraftProtection = OverDraftProtection.DISABLED;
                    break;
                case 3:
                    this.overDraftProtection = OverDraftProtection.AUTOMATICTRANSFER;
                default:
                    this.overDraftProtection = OverDraftProtection.ENABLED;
                    //// TODO: add transaction object to transactionHistory[]
            }
        }

        public double getBalance() {
            System.out.println("Your balance is currently: " + balance);
            return balance;
        }





 }



}
