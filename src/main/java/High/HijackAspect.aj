package High;

public aspect HijackAspect {

    // pointcut publicMethodExecuted(): execution(public * *(..));

    before(): execution(* High.CustomerList.addCustomer()) {
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : AOP hijacked the method");
        System.out.println("******");
    }

}
