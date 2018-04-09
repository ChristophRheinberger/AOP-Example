import Authorization.Account;
import Authorization.InterAccountTransferSystem;
import com.sun.security.auth.callback.TextCallbackHandler;

import javax.security.auth.login.LoginContext;

public class authMain {
    public static void main(String[] args) throws Exception {

        Account account1 = new Account(1);
        Account account2 = new Account(2);

        account1.credit(300);
        account1.debit(200);
        InterAccountTransferSystem.transfer(account1, account2, 100);
        InterAccountTransferSystem.transfer(account1, account2, 100);
    }
}
