package org.example;

import org.example.Aggregator.Aggregator;
import org.example.Aggregator.ListAggregator;
import org.example.Iterator.*;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome to iterator pattern!\n");

        DummyObject []objects = new DummyObject[5];

        for (int i = 0; i < 5; i++) {
            String name = "test " + i;
            DummyObject obj = new DummyObject(i, name);
            objects[i] = obj;
        }

        Aggregator<DummyObject> aggregator = new ListAggregator<>(objects);
        Iterator<DummyObject> iterator = aggregator.createIterator();

        while (iterator.hasNext()) {
            try {
                DummyObject obj = iterator.next();
                System.out.println(obj.getName());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        ArrayList<DummyObject> myList = new ArrayList<DummyObject>();
    }
}

class DummyObject {
    private int id;
    private String name;

    public DummyObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}