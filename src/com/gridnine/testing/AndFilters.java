package com.gridnine.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Класс для фильтрации полетов по нескольким правилам по принципу И
 * Полет подходит фильтрацию, если подходит всем условиям
 * 
 */

public class AndFilters extends Filters{

	private List<Filters> filters;
	
	AndFilters(Filters ...filters){
		this.filters = Arrays.asList(filters);
	}
	
	@Override
	boolean match(Flight flight) {
		boolean indicator = true;
		for(int i = 0; i < filters.size(); i++) {
			indicator = filters.get(i).match(flight);	
			if(!indicator) {
				break;
			}
		}
		return indicator;
	}
}