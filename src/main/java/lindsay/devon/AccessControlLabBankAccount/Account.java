package lindsay.devon.AccessControlLabBankAccount;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by devonlindsay on 9/13/16.
 */
public class Account {
        // to print in color System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

    private AccountHolder accountHolder;
    private InterestRate accountInterestRate;
    Scanner scanner = new Scanner(System.in);

    enum OverDraftProtection {ENABLED, DISABLED, AUTOMATICTRANSFER}
    enum Type {CHECKING, SAVINGS, INVESTMENT}
    enum Status {OPEN, CLOSED, FROZEN}
    enum Transactions {CREDIT, DEBIT, CHANGESTATUS, TRANSFERFUNDS, SETOVERDRAFT, }

    private boolean transactionCompleted;
    private double accountBalance;
    private double availableBalance;
    private static double idNumber = 000;
    private static double lastIdNumber = idNumber;
    private OverDraftProtection overDraftProtection;
    private Type type;
    private Status status;

    ArrayList<Transactions> history;

    //TODO once status/type is closed or set - how do I make it final?

    Account () {

        this.type = Type.SAVINGS;
        this.status = Status.OPEN;
        // todo this.idNumber = this.idNumber++;
        this.accountBalance = 0;
        this.accountHolder = new AccountHolder();
        this.accountInterestRate = new InterestRate();
        this.overDraftProtection = OverDraftProtection.ENABLED;
        this.transactionCompleted = false;
        this.history = new ArrayList<Transactions>();

    }

    public void transferFunds(Account secondaryAccount) {
        this.debit();
        secondaryAccount.credit();
        history.add(Transactions.TRANSFERFUNDS);
    }

    public void setStatusOptions() {
        System.out.println("What would you like to do?");
        System.out.println("[1] Close Account [2]Freeze account");
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            this.status = Status.CLOSED;
        } else {
            this.status = Status.FROZEN;
        }
    }

    public void setTypeOptions() {
        System.out.println("What would you like to do?");
        System.out.println(" [1]Savings [2] Checking [3] Investment");
        int setType = scanner.nextInt();
        setType(setType);
    }

    public void setType(int userInput) {
        switch (userInput) {
            case 1:
                this.type = Type.SAVINGS;
                break;
            case 2:
                this.type = Type.CHECKING;
                break;
            case 3:
                this.type = Type.INVESTMENT;
        }
    }

    public boolean creditTransactionCompleted() {
        if (//todo) {
            System.out.println("Your account balance has been updated.");
            System.out.println("Your new balance is: " + getBalance());
            history.add(Transactions.CREDIT);
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
            history.add(Transactions.DEBIT);
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
            if(this.status.equals(Status.OPEN)) {
                this.accountBalance = this.accountBalance + userInput;
            }
            else {
                System.out.println("Your account is currently frozen and cannot be accessed.");
            }
            creditTransactionCompleted();
            return false;
        }


        public boolean debit() {
            System.out.println("How much would you like to withdraw from your account?");
            Scanner scanner = new Scanner(System.in);
            double userInput = scanner.nextDouble();
            if (this.overDraftProtection.equals(OverDraftProtection.ENABLED)) {
                if ((userInput - this.accountBalance) < 0) {
                    System.out.println("Your account does not have enough funds to support this transaction");
                    return false;
                }
            }
            if(this.status.equals(Status.OPEN)) {
                this.accountBalance = this.accountBalance - userInput;
            } else {
                System.out.println("Your account is currently frozen and cannot be accessed.");
            }
            debitTransactionCompleted();
            return false;
        }


        public void overdraftProtectionOptions() {
            System.out.println("What would you like to do with Overdraft Protection?");
            System.out.println(" [1] ENABLE  [2] DISABLE  [3] SET UP AUTO TRANSFER FROM ANOTHER ACCOUNT");
            Scanner scanner = new Scanner(System.in);
            int setOverDraft = scanner.nextInt();
            setOverDraft(setOverDraft);
        }

        public void setOverDraft(int userInput) {
            history.add(Transactions.SETOVERDRAFT);
            switch (userInput) {
                case 1:
                    this.overDraftProtection = OverDraftProtection.ENABLED;
                    break;
                case 2:
                    this.overDraftProtection = OverDraftProtection.DISABLED;
                    break;
                case 3:
                    this.overDraftProtection = OverDraftProtection.AUTOMATICTRANSFER;
                    //TODO transferFunds();
                default:
                    this.overDraftProtection = OverDraftProtection.ENABLED;
            }
        }

        public double getBalance() {
            System.out.println("Your balance is currently: " + this.accountBalance);
            return this.accountBalance;
        }

        public void printHistory() {
            for(int i = 0; i < this.history.size(); i++ ) {
                System.out.println("ACCOUNT HISTORY:");
                System.out.println(this.history.get(i));
            }
        }



 }




