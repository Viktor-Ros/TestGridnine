package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Класс для фильтрации списка полетов по списку фильтров
 * 
 * 
 */

public class SearchFlights {

	 void search(List<Flight> listFlight, Filters filters){
		
		ArrayList<Flight> arraylistFlight = new ArrayList<>();
		for(int i = 0; i < listFlight.size(); i++) {
			boolean indicator = false;		
				if(filters.match(listFlight.get(i)) == true) {
					indicator = true;
			}
			if(indicator == true) {
				arraylistFlight.add(listFlight.get(i));
			}	
		}
		System.out.println("Результат фильтрации:");
		FlightBuilder.printFlightList(arraylistFlight);

	}
}