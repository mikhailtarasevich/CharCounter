package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheProviderImpl implements CacheProvider<String, LinkedHashMap<Character, Long>> {

	private Cache cache;

	public CacheProviderImpl (int size) {this.cache = new Cache(size);}

	public void put(String key, LinkedHashMap<Character, Long> value) {cache.put(key, value);}

	public LinkedHashMap<Character, Long> get(String key) {return cache.get(key);}

	public boolean contains(String key) {return cache.containsKey(key);}
	
	private class Cache extends LinkedHashMap<String, LinkedHashMap<Character, Long>> {

		private final int size;

		private Cache(int size) {
			super(size, 0.75f, true);
			this.size = size;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<String, LinkedHashMap<Character, Long>> eldest) {
			return size() > size;
		}
	}
	
}
