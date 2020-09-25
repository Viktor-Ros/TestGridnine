package com.gridnine.testing;

import java.time.LocalDateTime;

/*
 * 
 * Класс для исключения полетов до определенного момента времени 
 * 
 * 
 */


public class DateExcludeFilter extends Filters{

	private LocalDateTime date;
	
	DateExcludeFilter(LocalDateTime date){
		this.date = date;
	}
	
	@Override
	boolean match(Flight flight) {
				
		LocalDateTime dataFlight = flight.getSegments().get(0).getDepartureDate();//получение даты вылета					
		if(!date.isAfter(dataFlight)) {
			return true;
		}
		else return false;
	}
}