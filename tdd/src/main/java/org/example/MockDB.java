package org.example;

import java.util.ArrayList;
import java.util.List;

public class MockDB implements GererDB {
    private List<Data> dataStore = new ArrayList<>();

    public MockDB(String bd) {
        // constructor
    }

    @Override
    public void connect() {
        System.out.println("Connected to MockDB.");
    }

    @Override
    public void verify() {
        System.out.println("Verified MockDB.");
    }

    @Override
    public void create() {
        System.out.println("Database created.");
    }

    @Override
    public void drop() {
        dataStore.clear();
        System.out.println("Database dropped.");
    }

    @Override
    public void save(Data d) {
        dataStore.add(d);
        System.out.println("Data saved: " + d);
    }
}