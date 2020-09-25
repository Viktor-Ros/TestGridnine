package com.gridnine.testing;

import java.time.LocalDateTime;

/*
 * 
 * Класс для исключения полетов с сегментами у которых дата прилета раньше даты вылета
 * 
 * 
 */

public class SegmentArrBeforeDepFilter extends Filters{
	
	private boolean arrBeforeDep;

	SegmentArrBeforeDepFilter(boolean arrBeforeDep){
		this.arrBeforeDep = arrBeforeDep;
	}
	
	@Override
	boolean match(Flight flight) {
		
		boolean indicator = true;
		
		for(int i = 0; i < flight.getSegments().size(); i++) {
			Segment segment = flight.getSegments().get(i);				
			if(segment.getDepartureDate().isAfter((segment.getArrivalDate()))) {//сравнение даты прилета и даты вылета
				indicator = false;
				break;
			}
		}
		return indicator;
	}
}