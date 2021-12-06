package main.java.com.pluralsight.singleton;

public class SingletonEverydayDemo {
    public static void main(String[] args) {
        Runtime singletonRuntime = Runtime.getRuntime();
        singletonRuntime.gc(); // garbage collect so that we know it's the real runtime environment

        System.out.println(singletonRuntime); // obj address

        Runtime anotherInstance = Runtime.getRuntime();
        System.out.println(anotherInstance); // obj address

        if(singletonRuntime == anotherInstance)
            System.out.println("They are the same object.");
    }
}
