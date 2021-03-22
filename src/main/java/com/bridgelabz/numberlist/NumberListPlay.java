package com.bridgelabz.numberlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class NumberListPlay {

    public static void main(String[] args) {
        //creating sample Collection
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++)
            myNumberList.add(i);

        //Method 1 : traversing using Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Method 1 : Iterator Value:: " + i);
        }

        //Method 2 : Traversing with consumer interface implementation
        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("Method 2 : Consumer impl Value :: " + t);
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);

        //Method 3 : Traversing with Anonymous Consumer interface implementation
        myNumberList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Method 3 : forEach anonymous class Value :: " + integer);
            }
        });

        //Method 4 : Explicit Lambda Function
        Consumer<Integer> myListAction = n -> {
            System.out.println("Method 4 : forEach Lambda impl Value :: " + n);
        };
        myNumberList.forEach(myListAction);

        //Method 5 : Implicit Lambda Function
        myNumberList.forEach(n -> {
            System.out.println("Method 5 : forEach Lambda impl Value :: " + n);
        });

        //Method 6 : Implicit Lambda Function to print double value
        Function<Integer, Double> doubleFunction = Integer::doubleValue;
        myNumberList.forEach(n -> {
            System.out.println("Method 6 : forEach Lambda impl Value :: " +doubleFunction.apply(n));
        });
    }
}
