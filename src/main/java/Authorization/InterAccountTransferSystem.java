package Authorization;

import ReadWrite.InsufficientBalanceException;

public class InterAccountTransferSystem {
    public static void transfer(Account from, Account to, float amount)
        throws InsufficientBalanceException {
        to.credit(amount);
        from.debit(amount);
    }
}