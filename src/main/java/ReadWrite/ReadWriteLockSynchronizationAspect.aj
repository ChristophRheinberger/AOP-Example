package ReadWrite;

import EDU.oswego.cs.dl.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * Created by ClemensB on 07.04.18.
 */
public aspect ReadWriteLockSynchronizationAspect{

        public pointcut readOperations() : execution(* AspectAccount.get*(..)) || execution(* AspectAccount.toString(..));

        public pointcut writeOperations() : execution(* AspectAccount.credit*(..)) || execution(* AspectAccount.debit*(..)) || execution(* AspectAccount.set*(..));

        private ReadWriteLock lock = new ReentrantWriterPreferenceReadWriteLock();

        before() : readOperations() {
            try {
                lock.readLock().acquire();
                sleep(1000);
                System.out.println("ReadLock acquired by: " + thisJoinPoint.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        after() : readOperations() {
            lock.readLock().release();
            System.out.println("ReadLock released by: " + thisJoinPoint.toString());
        }

        before() : writeOperations() {
            try {
                lock.writeLock().acquire();
                sleep(1000);
                System.out.println("WriteLock acquired by: " + thisJoinPoint.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after() : writeOperations() {
            lock.writeLock().release();
            System.out.println("WriteLock released by: "  + thisJoinPoint.toString());
        }
}
