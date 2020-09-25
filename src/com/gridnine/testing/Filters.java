package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Абстрактный класс для создания фильтров
 * 
 * 
 */

public abstract class Filters {
	
	abstract boolean match(Flight flight);//возвращает true/false, в зависимость подошел ли полет по условию
}