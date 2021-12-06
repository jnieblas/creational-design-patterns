package main.java.com.pluralsight.prototype;

import java.util.List;

public class Statement implements Cloneable{

    private final String sql;
    private final List<String> parameters;
    private final Record record;

    public Statement(String sql, List<String> parameters, Record record) {
        this.sql = sql;
        this.parameters = parameters;
        this.record = record;
    }

    public Statement clone() {
        try {
            return (Statement) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getParameters() {
        return parameters;
    }

    public Record getRecord() {
        return record;
    }

    public String getSql() {
        return sql;
    }
}
