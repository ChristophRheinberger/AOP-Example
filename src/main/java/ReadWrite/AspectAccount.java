package ReadWrite;

import static java.lang.Thread.sleep;

/**
 * Created by ClemensB on 07.04.18.
 */
public class AspectAccount {
        private float _balance;
        private int _accountNumber;

        public AspectAccount(int accountNumber)
        {
            _accountNumber = accountNumber;
        }

        public void credit(float amount) {
            setBalance(getBalance() + amount);
            try {
                Thread one = new MyThread(this);
                one.start();
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void debit(float amount) throws InsufficientBalanceException {
                float balance = getBalance();
                if (balance < amount) {
                    throw new InsufficientBalanceException("Total balance not sufficient");
                } else {
                    setBalance(balance - amount);
                }
        }


        public float getBalance() {
            return _balance;
        }

        public void setBalance(float balance) {
            _balance = balance;
        }
}
