package Logging;

public class Account {
    private int amount = 500;

    public boolean isZero() {
        return (amount == 0);
    }

    public void addAmount(int x) {
        amount += x;
    }

    public void withdrawAmount(int x) {
        if (amount-x < 0) {
            
        }
    }
}
