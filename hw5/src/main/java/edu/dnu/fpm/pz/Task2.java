package edu.dnu.fpm.pz;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public static Map<String, City> getLargestCityPerState(Collection<City> cities) {
        Map<String, List<City>> citiesByState = cities.stream()
                .collect(Collectors.groupingBy(City::getState));

        Map<String, City> result = new HashMap<>();

        citiesByState.keySet()
                .forEach(state -> result.put(state, citiesByState.get(state).stream()
                        .max(Comparator.comparing(City::getPopulation))
                        .orElseThrow(IllegalArgumentException::new)));

        return result;
    }

}
