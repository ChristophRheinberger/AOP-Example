package ReadWrite;

import EDU.oswego.cs.dl.util.concurrent.*;

/**
 * Created by ClemensB on 07.04.18.
 */
public aspect ReadWriteLockSynchronizationAspect{

        public pointcut readOperations() : execution(* AspectAccount.get*(..)) || execution(* AspectAccount.toString(..));

        public pointcut writeOperations() : execution(* AspectAccount.credit*(..))
            && !readOperations();

        private ReadWriteLock lock = new ReentrantWriterPreferenceReadWriteLock();

        before() : readOperations() {
            try {
                lock.readLock().acquire();
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
                System.out.println("WriteLock acquired!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after() : writeOperations() {
            lock.writeLock().release();
            System.out.println("WriteLock released!");
        }

        static aspect SoftenInterruptedException {
            declare soft : InterruptedException :
                call(void Sync.acquire());
        }
}
