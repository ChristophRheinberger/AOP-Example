import Logging.AccountException;
import Logging.AccountManualLogging;

/**
 * Created by Christoph on 07.04.2018.
 */
public class logMainManual {

    public static void main(String[] args ) {

        AccountManualLogging account = new AccountManualLogging();

        account.addAmount(500);

        account.isZero();

        try {
            account.withdrawAmount(150);
        } catch (AccountException e) {
            e.printStackTrace();
        }

    }
}