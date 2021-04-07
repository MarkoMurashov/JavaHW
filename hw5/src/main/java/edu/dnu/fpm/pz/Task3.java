package edu.dnu.fpm.pz;

import java.util.Iterator;
import java.util.stream.Stream;

public class Task3 {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Stream<T> combined = Stream.empty();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            combined = Stream.concat(combined, Stream.of(firstIterator.next(), secondIterator.next()));
        }

        return combined;
    }
}
