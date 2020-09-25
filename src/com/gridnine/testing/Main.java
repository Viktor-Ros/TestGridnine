package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Flight> listFlight = FlightBuilder.createFlights();
		FlightBuilder.printFlightList(listFlight);		
		
		SearchFlights searchFlights = new SearchFlights();//searchFlights
		
		searchFlights.search(listFlight, new DateExcludeFilter(LocalDateTime.now()));
		searchFlights.search(listFlight, new SegmentArrBeforeDepFilter(true));
		searchFlights.search(listFlight,  new LandTimeFilter(2));
		
		//searchFlights.search(listFlight, new OrFilters(new DateExcludeFilter(LocalDateTime.now()), new SegmentArrBeforeDepFilter(true), new LandTimeFilter(2)));
		//searchFlights.search(listFlight, new AndFilters(new DateExcludeFilter(LocalDateTime.now()), new SegmentArrBeforeDepFilter(true), new LandTimeFilter(2)));
	}
}