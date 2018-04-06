package ReadWrite;

/**
 * Created by ClemensB on 07.04.18.
 */
public abstract class AspectAccount {
        private float _balance;
        private int _accountNumber;

        public AspectAccount(int accountNumber)
        {
            _accountNumber = accountNumber;
        }

        public void credit(float amount) {
            setBalance(getBalance() + amount);
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
