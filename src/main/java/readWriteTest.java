import ReadWrite.Account;
import ReadWrite.AspectAccount;
import ReadWrite.InsufficientBalanceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Clemens on 05.04.2018.
 */
public class readWriteTest {
    static Account account = new Account(1);

    public static void main(String[] args ) {
        account.setBalance(5000);

        account.credit(1000);

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new readWriteTestAOP.MyThread(1000));
        threadPool.submit(new readWriteTestAOP.MyThread(2000));

        threadPool.shutdown();

    }

    private static class MyThread implements Runnable {

        private int i;

        public MyThread(int i) {
            this.i = i;
        }

        public void run() {
            try {
                account.debit(i);
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }
        }
    }
}
