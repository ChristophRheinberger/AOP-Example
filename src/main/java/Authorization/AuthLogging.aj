package Authorization;

import org.aspectj.lang.Signature;

public aspect AuthLogging extends IndentedLogging{
    declare precedence: AuthLogging, *;

    public pointcut accountActivities() : execution(public * Account.*(..))
                        || execution(public * InterAccountSystem.*(..));

    public pointcut loggedOperations() : accountActivities();

    before() : loggedOperations() {
        Signature sig = thisJoinPointStaticPart.getSignature();
        System.out.println("<" + sig.getName() + ">");
    }
}
