package ReadWrite;

/**
 * Created by Christoph on 07.04.2018.
 */
public class MyThread extends Thread {

    AspectAccount account;

    public MyThread(AspectAccount account) {
        this.account = account;
    }

    public void run() {
        try {
             account.debit(1000);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
    }
}
