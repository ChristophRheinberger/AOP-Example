package ReadWrite;

import EDU.oswego.cs.dl.util.concurrent.*;

/**
 * Created by ClemensB on 07.04.18.
 */
public abstract aspect ReadWriteLockSynchronizationAspect perthis(readOperations() || writeOperations()) {
        public abstract pointcut readOperations();
        public abstract pointcut writeOperations();

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
