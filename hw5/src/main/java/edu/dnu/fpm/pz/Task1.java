package edu.dnu.fpm.pz;

import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    public static String execute(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n % 2 == 0 ? "e" + n : "o" + n)
                .collect(Collectors.joining(","));
    }
}
