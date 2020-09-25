package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Factory class to get sample list of flights.
 */

class FlightBuilder {
    static List<Flight> createFlights() {
    	
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        
        return Arrays.asList(
            //A normal flight with two hour duration
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
            //A normal multi segment flight
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
            //A flight departing in the past
            createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
            //A flight that departs before it arrives
            createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
            //A flight with more than two hours ground time
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
            //Another flight with more than two hours ground time
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    private static Flight createFlight(final LocalDateTime... dates) {//метод для создания полета
    	
        if ((dates.length % 2) != 0) {//если кол-во дат не кратно 2
            throw new IllegalArgumentException(
                "you must pass an even number of dates");
        }
        
        List<Segment> segments = new ArrayList<>(dates.length / 2);//лист сегментов, меньше массива дат в 2 раза
        for (int i = 0; i < (dates.length - 1); i += 2) {//создаем новый сегмент из последовательных двух дат
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        
        return new Flight(segments);
    }
    
    static void printFlightList(List<Flight> listFlight) {//метод для вывода листа полетов
    
    	for(int i = 0; i < listFlight.size(); i++) {
    		System.out.println("Полет " + " ::::::::::::::::::::::::::::::::::::::::");
    		System.out.println(listFlight.get(i).toString());	
    	}
    }
}





























