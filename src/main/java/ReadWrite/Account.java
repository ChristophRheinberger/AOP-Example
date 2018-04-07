package ReadWrite;

import EDU.oswego.cs.dl.util.concurrent.*;

import static java.lang.Thread.sleep;

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

            sleep(5000);

            System.out.println("Writelock acquired");

                setBalance(getBalance() + amount);
            } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
            } finally {
                lock.writeLock().release();
                System.out.println("Writelock released: " +  + _balance);
            }
    }

    public void debit(float amount) throws InsufficientBalanceException {
            try {
                lock.writeLock().acquire();

                sleep(5000);

                System.out.println("Writelock acquired");

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
                System.out.println("Writelock released: " + _balance);
            }
    }


    public float getBalance() {
        try {
            lock.readLock().acquire();

            System.out.println("Readlock acquired");
            return _balance;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.readLock().release();
            System.out.println("Readlock released");
        }
        }
    public void setBalance(float balance) {
        try {
            lock.writeLock().acquire();

            System.out.println("Writelock acquired:");
            _balance = balance;
            } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
            } finally {
            lock.writeLock().release();
            System.out.println("Writelock released");
            }
    }
}
