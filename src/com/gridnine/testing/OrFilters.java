package com.gridnine.testing;

import java.util.Arrays;
import java.util.List;

/*
 * 
 * Класс для фильтрации полетов по нескольким правилам по принципу ИЛИ
 * Полет подходит фильтрацию, если подходит по любому условию
 * 
 */

public class OrFilters extends Filters{//фильтрация по ИЛИ

	private List<Filters> filters;
	
	OrFilters(Filters ...filters){
		this.filters = Arrays.asList(filters);
	}
	
	@Override
	boolean match(Flight flight) {
		boolean indicator = false;
		for(int i = 0; i < filters.size(); i++) {
			indicator = filters.get(i).match(flight);	
			if(indicator) {
				break;
			}
		}
		return indicator;
	}
}