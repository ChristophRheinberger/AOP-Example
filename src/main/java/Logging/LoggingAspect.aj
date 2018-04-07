package Logging;

public aspect LoggingAspect {

    pointcut publicMethodExecuted(): execution(public * *(..));

    before(): publicMethodExecuted() {
        System.out.println("In class: " + thisJoinPoint.getTarget().getClass() + ": logging with AspectJ");
        System.out.println("******");
    }
}
