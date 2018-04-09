package Authorization;

import Authorization.interfaces.AccountInterface;
import ReadWrite.InsufficientBalanceException;

import java.security.AccessController;

public class Account implements AccountInterface {
    private int _accountNumber;
    private float _balance;

    public Account (int accountNumber) {
        this._accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        AccessController.checkPermission(new BankingPermission("getAccountNumber"));
        return _accountNumber;
    }

    public void credit(float amount) {
        AccessController.checkPermission(new BankingPermission("credit"));
        _balance= _balance + amount;
    }

    public void debit(float amount) throws InsufficientBalanceException {
        AccessController.checkPermission(new BankingPermission("debit"));
        if (_balance <amount) {
            throw new InsufficientBalanceException("Total balance not sufficient");
        } else {
            _balance = _balance - amount;
        }
    }

    public float getBalance() {
        return _balance;
    }
}
