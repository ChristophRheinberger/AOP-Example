import ReadWrite.AspectAccount;

/**
 * Created by Christoph on 07.04.2018.
 */
public class lockMain {
    public static void main(String[] args ) {

        AspectAccount account = new AspectAccount(1);
        account.credit(1000);

    }
}
