import Logging.Account;
import Logging.AccountException;

/**
 * Created by Christoph on 07.04.2018.
 */
public class logMain {

    public static void main(String[] args ) {

        Account account = new Account();

        account.addAmount(500);

        account.isZero();

        try {
            account.withdrawAmount(150);
        } catch (AccountException e) {
            e.printStackTrace();
        }

    }
}