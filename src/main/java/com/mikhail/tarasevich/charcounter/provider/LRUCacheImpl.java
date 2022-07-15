package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl implements LRUCache {
	private Map<String, LinkedHashMap<Character, Long>> cache;
	private int windowSize;

	public LRUCacheImpl(final int windowSize) {
		this.windowSize = windowSize;
		this.cache = new LinkedHashMap<String, LinkedHashMap<Character, Long>>() {

			@Override
			protected boolean removeEldestEntry(Map.Entry<String, LinkedHashMap<Character, Long>> eldest) {
				return size() > windowSize;
			}
		};

	}

	public Map<String, LinkedHashMap<Character, Long>> getCache(){
		return cache;
	}
	
	public void cacheable(String key, LinkedHashMap<Character, Long> data) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		}

		cache.put(key, data);

	}
}
