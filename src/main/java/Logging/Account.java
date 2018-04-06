package Logging;

public class Account {
    private int amount = 500;

    public boolean isZero() {
        return (amount == 0);
    }

    public void addAmount(int x) {
        amount += x;
    }

    public void withdrawAmount(int x) throws AccountException {
        if (amount-x < 0) {
            throw new AccountException();
        } else {
            amount = amount - x;
        }
    }
}



class AccountException extends Exception {
    public AccountException() { super(); }
    public AccountException(String message) { super(message); }
    public AccountException(String message, Throwable cause) { super(message, cause); }
    public AccountException(Throwable cause) { super(cause); }
}