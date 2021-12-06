package main.java.com.pluralsight.builder;

public class LunchOrder {

    // Static constructor. Operates as a container until we tell it to finally make our lunch order
    public static class Builder {
        private final String meat;
        private String bread;
        private String condiments;
        private String dressing;

        // We could enforce required params via this constructor
        // Otherwise, offers flexibility
        // If one of the params is null, we can also set a default value
        public Builder(String meat) {
            this.meat = meat;
        }

        public LunchOrder build() {
            return new LunchOrder(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }
    }

    private final String meat;
    private final String bread;
    private final String condiments;
    private final String dressing;

    // Enforces the contract within the builder
    private LunchOrder(Builder builder) {
        this.meat = builder.meat;
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
    }

    // Only getters, so we're not mutable
    public String getMeat() {
        return meat;
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
}
