package Hijack;

public aspect HijackAspect {

    before(): execution(* Hijack.CustomerList.addCustomer()) {
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : AOP hijacked the method");
        System.out.println("******");
    }

}
