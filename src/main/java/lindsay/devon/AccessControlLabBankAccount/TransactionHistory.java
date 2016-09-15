package lindsay.devon.AccessControlLabBankAccount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
/**
 * Created by devonlindsay on 9/13/16.
 */
class TransactionHistory {

TransactionHistory transactionHistory;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

TransactionHistory(Account account) {

    System.out.println(dateFormat.format(date));
    System.out.println(account);
    System.out.println();

}

}

