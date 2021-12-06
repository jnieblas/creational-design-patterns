package main.java.com.pluralsight.builder;

public class LunchOrderBuilderDemo {

    public static void main(String[] args) {
        LunchOrder.Builder builder = new LunchOrder.Builder("Bacon");
        // We can cut out any of these & it will work perfectly fine
        builder.bread("Wheat").condiments("Lettuce").dressing("Mayo");

        // Once built, we can't edit this. Offers immutability
        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }
}
