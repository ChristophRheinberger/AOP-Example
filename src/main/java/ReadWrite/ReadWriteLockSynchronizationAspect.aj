package ReadWrite;

import EDU.oswego.cs.dl.util.concurrent.*;

/**
 * Created by ClemensB on 07.04.18.
 */
public abstract aspect ReadWriteLockSynchronizationAspect{

        public pointcut readOperations() : execution(* Account.get*(..)) || execution(* Account.toString(..));

        public pointcut writeOperations() : execution(* Account.*(..))
            && !readOperations();

        private ReadWriteLock lock = new ReentrantWriterPreferenceReadWriteLock();

        before() : readOperations() {
            try {
                lock.readLock().acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        after() : readOperations() {
            lock.readLock().release();
        }

        before() : writeOperations() {
            try {
                lock.writeLock().acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after() : writeOperations() {
            lock.writeLock().release();
        }

        static aspect SoftenInterruptedException {
            declare soft : InterruptedException :
            call(void Sync.acquire());
        }
}
