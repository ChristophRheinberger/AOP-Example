package ReadWrite;

/**
 * Created by ClemensB on 07.04.18.
 */
public aspect BankingSynchronizationAspect extends ReadWriteLockSynchronizationAspect{
    public pointcut readOperations() : execution(¤ Account.get¤(..)) || execution(¤ Account.toString(..));

    public pointcut writeOperations() : execution(¤ Account.¤(..))
            && !readOperations();
}
