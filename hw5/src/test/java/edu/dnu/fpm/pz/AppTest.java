package edu.dnu.fpm.pz;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

public class AppTest 
{
    @Test
    public void testEvenOddMarker() {
        //GIVEN
        String expected = "o11,o15,o17,e20,e40,e50";
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(11,15,17,20,40,50));
        //WHEN
        String actual = Task1.execute(nums);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLargestCityPerState() {
        //GIVEN
        City c1 = new City("City_1", "1", 99);
        City c2 = new City("City_2", "1", 100);
        City c3 = new City("City_3", "1", 10);
        City c4 = new City("City_4", "2", 300);
        City c5 = new City("City_5", "2", 302);
        City c6 = new City("City_6", "2", 304);
        List<City> cities = new ArrayList<City>(Arrays.asList(c1, c2, c3, c4, c5, c6));
        Map<String, City> expected = new HashMap<>();
        expected.put("1", c2);
        expected.put("2", c6);
        //WHEN
        Map<String, City> dict = Task2.getLargestCityPerState(cities);
        //THEN
        dict.forEach((key, val) -> assertEquals(expected.get(key),val));
    }

    @Test
    public void testZip() {
        //GIVEN
        List<Integer> expectedElements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int expectedSize = 10;

        Stream<Integer> stream1 = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> stream2 = Stream.of(2, 4, 6, 8, 10);
        //WHEN
        List<Integer> zipped = Task3.zip(stream1, stream2).collect(toList());
        //THEN
        assertEquals(expectedSize, zipped.size());
        for (int i = 0; i < zipped.size(); i++) {
            assertEquals(expectedElements.get(i), zipped.get(i));
        }
    }

}
