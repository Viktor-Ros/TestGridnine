package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;

/*
 * 
 * Класс для исключения полетов, у которых общее время на земле больше заданного времени в часах
 * 
 * 
 */

public class LandTimeFilter extends Filters{

	private long landTime;
	
	LandTimeFilter(long landTime){
		this.landTime = landTime;
	}
	
	@Override
	boolean match(Flight flight) {
		
		long flightLandTime = 0;//время на земле
		
		for(int i = 1; i < flight.getSegments().size(); i++) {
			Segment segmentDep = flight.getSegments().get(i);
			Segment segmentArr = flight.getSegments().get(i-1);
			LocalDateTime depTime = segmentDep.getDepartureDate();//время отбытия
			LocalDateTime arTime = segmentArr.getArrivalDate();//время прибытия 											
			flightLandTime += Duration.between(arTime, depTime).toHours();
		}
						
		if(flightLandTime <= landTime) {
			return true;
		}	
		else return false;
	}
}