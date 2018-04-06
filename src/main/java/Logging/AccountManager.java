package Logging;

public class AccountManager {

    Account testAccount = new Account();

    public void getSalary() {
        testAccount.addAmount(500);
    }

    public void payRent(int rent) {
        try {
            testAccount.withdrawAmount(rent);
        } catch (AccountException e) {
            System.out.println("Not enough money on account!");
        }
    }
}
