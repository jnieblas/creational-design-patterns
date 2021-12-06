package main.java.com.pluralsight.prototype;

public abstract class Item implements Cloneable{
    private String title;
    private double price;
    private String url;

    /*
    Returns Object, but doesn't understand generics because implement w/ Java 1.0.
    It is recommended that you create your own clone method so that you can make it more intelligently return the object type you expect.
    Otherwise, will require type casting your object to the object you want everytime you clone.
    */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
