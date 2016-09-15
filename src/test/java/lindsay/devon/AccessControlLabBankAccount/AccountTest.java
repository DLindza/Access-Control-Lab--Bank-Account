package lindsay.devon.AccessControlLabBankAccount;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by devonlindsay on 9/14/16.
 */
public class AccountTest {
    Account accountTest;

    @Before
    public void initialize() {
        accountTest = new Account();
        String input = "100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }

    @Test
    public void creditTest() {
        accountTest.credit();
        Assert.assertEquals(100, accountTest.getBalance(), 1);
    }

    @Test
    public void debitTest() {
        accountTest.debit();
        Assert.assertEquals(-100, accountTest.getBalance(), 1);
    }

    @Test
    public void getBalanceTest() {
        Assert.assertEquals(0, accountTest.getBalance(),1);
    }


//    @Test
//    public void creditTransactionCompleteTest() {
//        Assert.assertEquals("This should be true", true, balanceTest.creditTransactionCompleted());}
//

//    @Test
//    public void freezeAccountTest() {Assert.assertEquals("This should return false", false, balanceTest.freezeAccount();}

//    @Test
//      public void setOverdraftProtectionTest () {Assert.assertEquals("This shohuld return true", true, balanceTest.setOverdraftProtection();}

//    public void setOverdraftProtection() {
//        System.out.println("Your account now has overdraft protection");
//        this.overdraftProtection = true;
//        //// TODO: add transaction object to transactionHistory[]
//    }
//
//    public double getBalance() {
//        System.out.println("Your balance is currently: " + balance);
//        return balance;
//    }
}
