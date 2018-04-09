package Logging;

public aspect LoggingAspect {

    pointcut MethodsWithIntegerArguments(): execution(public * Logging.Account.*(int));

    pointcut MethodsWithoutArguments(): execution(public * Logging.Account.*());

    before(): MethodsWithIntegerArguments() {
        System.out.println("******");
        System.out.println("logging with AspectJ in class: " + thisJoinPoint.getTarget().getClass().getName() +
                            ", in method: " + thisJoinPoint.toString() +
                            ", with parameter: " + thisJoinPoint.getArgs()[0].toString());
    }

    before(): MethodsWithoutArguments() {
        System.out.println("******");
        System.out.println("logging with AspectJ in class: " + thisJoinPoint.getTarget().getClass().getName() +
                            ", in method: " + thisJoinPoint.toString());
    }
}
