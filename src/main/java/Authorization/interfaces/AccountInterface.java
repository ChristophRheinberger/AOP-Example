package Authorization.interfaces;

import ReadWrite.InsufficientBalanceException;

public interface AccountInterface {
    public int getAccountNumber();
    public void credit(float amount);
    public void debit(float amount) throws InsufficientBalanceException;
    public float getBalance();
}