package Logging;

public aspect LoggingAspect {

    pointcut publicMethodExecuted(): execution(public * *.abcd(..));

    before(): publicMethodExecuted() {
        System.out.println("logging with AspectJ");
        System.out.println("******");
    }
}
