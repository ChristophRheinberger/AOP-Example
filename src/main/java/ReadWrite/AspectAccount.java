package ReadWrite;

import static java.lang.Thread.sleep;

/**
 * Created by ClemensB on 07.04.18.
 */
public class AspectAccount {
        public float _balance;
        private int _accountNumber;

        public AspectAccount(int accountNumber)
        {
            _accountNumber = accountNumber;
        }

        public void credit(float amount) {
            setBalance(_balance + amount);
            System.out.println("Amount added, Balance is: " + this._balance);

            // Only for demonstration purposes
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // demonstration purposes end
        }

        public void debit(float amount) throws InsufficientBalanceException {
            float balance = _balance;

            if (balance < amount) {
                throw new InsufficientBalanceException("Total balance not sufficient");
            } else {
                setBalance(balance - amount);
            }
            System.out.println("Amount withdrawn, Balance is: " + this._balance);
        }

        public float getBalance() {
            return _balance;
        }

        public void setBalance(float balance) {
            _balance = balance;
        }
}
