package ReadWrite;

import EDU.oswego.cs.dl.util.concurrent.*;

/**
 * Created by Clemens on 05.04.2018.
 */
public class Account {
    private float _balance;
    private int _accountNumber;

    private ReadWriteLock lock = new ReentrantWriterPreferenceReadWriteLock();

    public Account(int accountNumber) {
        _accountNumber = accountNumber;
        }

     public void credit(float amount) {
        try {
            lock.writeLock().acquire();
                setBalance(getBalance() + amount);
            } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
            } finally {
                lock.writeLock().release();
            }
    }

    public void debit(float amount) throws InsufficientBalanceException {
            try {
                lock.writeLock().acquire();
                float balance = getBalance();
                if (balance < amount) {
                    throw new InsufficientBalanceException("Total balance not sufficient");
                } else {
                    setBalance(balance - amount);
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } finally {
                lock.writeLock().release();
            }
    }


    public float getBalance() {
        try {
            lock.readLock().acquire();
            return _balance;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.readLock().release();
        }
        }
    public void setBalance(float balance) {
        try {
            lock.writeLock().acquire();
            _balance = balance;
            } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
            } finally {
            lock.writeLock().release();
            }
    }
}
