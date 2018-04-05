import ReadWrite.Account;
import ReadWrite.InsufficientBalanceException;

/**
 * Created by Clemens on 05.04.2018.
 */
public class readWriteTest {
    public static void main(String[] args) throws InsufficientBalanceException{
        Account account = new Account(123456);
        account.credit(100);
        account.debit(50);

    }
}
