package com.alvin.nosql.api;


public interface Collection<T> {

	ItemFilter<T> getDataFilter();
	
	T[] applyFilter(ItemFilter<T> filter);
}
