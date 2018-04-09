package ReadWrite;

import EDU.oswego.cs.dl.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * Created by ClemensB on 07.04.18.
 */
public aspect ReadWriteLockSynchronizationAspect{

        public pointcut readOperations() : execution(* *.get*(..)) || execution(* *.toString(..));

        public pointcut writeOperations() : execution(* *.credit*(..)) || execution(* *.debit*(..));

        private ReadWriteLock lock = new ReentrantWriterPreferenceReadWriteLock();

        before() : readOperations() {
            try {
                lock.readLock().acquire();
                sleep(1000);
                System.out.println("ReadLock acquired!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        after() : readOperations() {
            lock.readLock().release();
            System.out.println("ReadLock released!");
        }

        before() : writeOperations() {
            try {
                lock.writeLock().acquire();
                sleep(1000);
                System.out.println("WriteLock acquired!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after() : writeOperations() {
            lock.writeLock().release();
            System.out.println("WriteLock released!");
        }
}
