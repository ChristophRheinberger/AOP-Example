package Authorization;

import org.aspectj.lang.JoinPoint;

import java.security.Permission;

public aspect BankingAuthAspect extends AbstractAuthAspect {
    public pointcut authOperations() : execution(public * Account.*(..))
                        || execution(public * InterAccountTransferSystem.*(..));

    public Permission getPermission(JoinPoint.StaticPart joinPointStaticPart) {
        return new BankingPermission(joinPointStaticPart.getSignature().getName());
    }
}
