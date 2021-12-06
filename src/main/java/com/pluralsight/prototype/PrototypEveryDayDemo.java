package main.java.com.pluralsight.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypEveryDayDemo {
    public static void main(String[] args) {
        String sql = "select * from movies where title = ?";
        List<String> parameters = new ArrayList<>();
        parameters.add("Star wars");
        Record record = new Record();

        Statement firstStatement = new Statement(sql, parameters, record);
        System.out.println(firstStatement.getSql());
        System.out.println(firstStatement.getParameters());
        System.out.println(firstStatement.getRecord());

        Statement second = firstStatement.clone();
        System.out.println(second.getSql());
        System.out.println(second.getParameters());
        System.out.println(second.getRecord()); // Returns same record & list, this is a shallow copy
        // A deep copy would return new arraylist with same params & new record object
    };
};
