package edu.dnu.fpm.pz;


import java.util.*;
import java.util.stream.Stream;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Task #1");
        System.out.println(Task1.execute(new ArrayList<Integer>(Arrays.asList(11,15,17,20,40,50))));

        System.out.println("\nTask #2");

        City c1 = new City("Los Angeles", "California", 700000);
        City c2 = new City("Chicago", "Illinois", 550000);
        City c3 = new City("San Jose", "California", 50000);
        City c4 = new City("Austin", "Texas", 20000);
        City c5 = new City("McKinney", "Texas", 15000);
        City c6 = new City("Aurora", "Illinois", 90000);

        Map<String, City> dict = Task2.getLargestCityPerState(new ArrayList<City>(Arrays.asList(c1, c2, c3, c4, c5, c6)));
        dict.forEach((key, val) -> System.out.println(key + " -> " + val));

        System.out.println("\nTask #3");

        Stream<Character> stream1 = Stream.of('a', 'c', 'e', 'g');
        Stream<Character> stream2 = Stream.of('b', 'd', 'f', 'h', 'i');
        Task3.zip(stream1, stream2).forEach(System.out::println);
    }

}
