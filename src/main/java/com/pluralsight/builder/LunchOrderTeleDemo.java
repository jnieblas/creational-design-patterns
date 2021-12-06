package main.java.com.pluralsight.builder;

public class LunchOrderTeleDemo {
    public static void main(String[] args) {
        LunchOrderTele tele = new LunchOrderTele("Wheat", "Lettuce", "Mustard", "Ham");

        System.out.println(tele.getBread());
        System.out.println(tele.getCondiments());
        System.out.println(tele.getDressing());
        System.out.println(tele.getMeat());
    }
}
