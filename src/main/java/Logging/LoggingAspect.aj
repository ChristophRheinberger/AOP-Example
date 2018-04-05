package Logging;

public aspect LoggingAspect {

    pointcut publicMethodExecuted(): execution(public * *(..));

    before(): publicMethodExecuted() {
        System.out.println("logging with AspectJ");
        System.out.println("******");
    }

}
