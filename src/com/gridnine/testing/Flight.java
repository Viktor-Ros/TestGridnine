package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */

class Flight {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) {//конструктор полета со списком сегментов segments
        segments = segs;
    }

    List<Segment> getSegments() {//геттер для списка сегментов segments
        return segments;
    }

    @Override
    public String toString() {//вывод в консоль
        return segments.stream().map(Object::toString)
            .collect(Collectors.joining(" "));
    }
}
