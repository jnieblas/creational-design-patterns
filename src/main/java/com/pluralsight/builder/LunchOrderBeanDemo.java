package main.java.com.pluralsight.builder;

public class LunchOrderBeanDemo {

    public static void main(String[] args) {
        LunchOrderBean bean = new LunchOrderBean();

        bean.setBread("Wheat");
        bean.setCondiments("Lettuce");
        bean.setDressing("Mustard");
        bean.setMeat("Ham");

        System.out.println(bean.getBread());
        System.out.println(bean.getCondiments());
        System.out.println(bean.getDressing());
        System.out.println(bean.getMeat());
    }
}
