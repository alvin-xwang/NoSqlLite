package com.alvin.nosql.api;


public interface ItemFilter<T> {

	boolean match(T item);
}
