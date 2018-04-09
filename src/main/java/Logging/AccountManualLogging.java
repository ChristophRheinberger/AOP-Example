package Logging;

public class AccountManualLogging {

    private int amount = 500;

    public boolean isZero() {

        System.out.println("The account is empty: " + (amount == 0));

        return (amount == 0);
    }

    public void addAmount(int x) {
        amount += x;

        System.out.println("Added to Account: " + x + " , new Amount: " + amount);
    }

    public void withdrawAmount(int x) throws AccountException {
        if (amount - x < 0) {
            throw new AccountException();
        } else {
            amount = amount - x;
        }

        System.out.println("Withdrawn from Account: " + x + " , new Amount: " + amount);
    }

}

