package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Bean that represents a flight segment.
 */

class Segment {
    private final LocalDateTime departureDate;//дата отбытия

    private final LocalDateTime arrivalDate;//дата прибытия

    Segment(final LocalDateTime dep, final LocalDateTime arr) {//конструктор сегмента с датами отбытия и прибытия
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    LocalDateTime getDepartureDate() {//геттер для даты отбытия
        return departureDate;
    }

    LocalDateTime getArrivalDate() {//геттер для даты прибытия
        return arrivalDate;
    }

    @Override
    public String toString() {//вывод в консоль
        DateTimeFormatter fmt =
            DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
            + ']';
    }
}
