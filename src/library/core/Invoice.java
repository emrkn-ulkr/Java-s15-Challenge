package library.core;

public class Invoice {
    public static void pay(Double amount){
        System.out.println("Invoice paid "+ amount);
    }

    public static void refund(Double amount){
        System.out.println("Refunded: "+amount);
    }
}
