package main.java.com.pluralsight.builder;

/*
 * Telescoping:
 * Creating constructors that feed into each other via overloading.
 * They somewhat recursively go down the list of constructors due to internal this() calls.
 * This example is immutable - once created, can't be changed.
 * Problems:
 * Telescoping can go up (like what is done below) or down (the opposite of this class).
 * What happens if I build a sandwich where I don't want dressing?
 * This example won't do this, I would need another constructor to accomodate for this example.
 */
public class LunchOrderTele {

    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderTele(String bread) {
        this.bread = bread;
    }

    public LunchOrderTele(String bread, String condiments) {
        this(bread);
        this.condiments = condiments;
    }

    public LunchOrderTele(String bread, String condiments, String dressing) {
        this(bread, condiments);
        this.dressing = dressing;
    }

    public LunchOrderTele(String bread, String condiments, String dressing, String meat) {
        this(bread, condiments, dressing);
        this.meat = meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}
