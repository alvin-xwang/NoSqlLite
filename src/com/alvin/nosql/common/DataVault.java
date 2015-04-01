package com.alvin.nosql.common;

import java.util.HashMap;
import java.util.Map;

import com.alvin.nosql.api.Collection;

public class DataVault {

	public static final DataVault NULL = new DataVault();

	private Map<String, Collection> dataMap = null;

	public DataVault() {
		dataMap = new HashMap<String, Collection>();
	}

	public void create() {
		
	}

	public void delete() {
		
	}

	public void update(String key, Collection collection) {
		dataMap.put(key,  collection);
	}

	public <T> Collection<T> findCollection(String key, Class<T> clazz) {
		return dataMap.get(key);
	}
}
