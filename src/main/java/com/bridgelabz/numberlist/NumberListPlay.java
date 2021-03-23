package com.bridgelabz.numberlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
            System.out.println("Method 6 : forEach Lambda impl Value :: " + doubleFunction.apply(n));
        });

        //Method 7 : Implicit Lambda Function to check and print even
        Predicate<Integer> isEvenFunction = n -> n % 2 == 0;
        myNumberList.forEach(n -> {
            System.out.println("Method 7 : forEach value of : " + n + " check for Even : " + isEvenFunction.test(n));
        });

        //Before using stream
        List<Double> doublelist = new ArrayList<>();
        myNumberList.forEach(n -> {
            doublelist.add(doubleFunction.apply(n));
            doublelist.forEach(n1 -> {
                System.out.println("Method 8 : forEach value of: " +n+" check for Even : "+ isEvenFunction.test(n1.intValue()));
            });
        });
        
        //Method 8 : Create Strean and iterate list to show elements of stream
        myNumberList.stream().forEach( n -> {
            System.out.println("Method 8 : forEach value of: " +n);
        });

        //Method 9 : Process the stream, Apply operations on the stream and then store the result
        //Ability to store values in the new list
        List<Double> streamList = myNumberList.stream().filter(isEvenFunction).map(doubleFunction).collect(Collectors.toList());
        System.out.println("Method 9 : Printing Double List : " +streamList);

        //Method 10 : Find even number
        List<Integer> filterEven  = myNumberList.stream().filter(isEvenFunction).collect(Collectors.toList());
        System.out.println("Method 10 : Even numbers from list : " +filterEven);

        //Method 11 : Find first even
        Integer first  = myNumberList.stream().filter(isEvenFunction).peek(n -> System.out.println("Peek even number : " +n)).findFirst().orElse(null);
        System.out.println("Method 11 : Peak First Even : " +first);

        //Method 12 : Find min and max even number
        Integer min = myNumberList.stream().filter(isEvenFunction).min((n1, n2) -> n1 - n2).orElse(null);
        System.out.println("Method 12 : Minimum Even : " +min);

        Integer max = myNumberList.stream().filter(isEvenFunction).max(Comparator.comparing(Integer::intValue)).orElse(null);
        System.out.println("Method 12 : Maximum Even : " +max);
    }
}
