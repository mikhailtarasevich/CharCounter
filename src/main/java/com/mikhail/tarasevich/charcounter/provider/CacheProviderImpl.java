package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheProviderImpl<K,V> implements CacheProvider<K, V> {
	private K key;
	private V value;
	private Cache cache = new Cache(2);

	private class Cache extends LinkedHashMap<K, V> {

		private int size;

		private Cache(int size) {
			super(size, 0.75f, true);
			this.size = size;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			return size() > size;
		}
	}

	public void put(K key, V value) {
		cache.put(key, value);
	}

	public V get(K key) {
		
		return cache.get(key);
	}

	public boolean contains(K key) {
		
		return cache.containsKey(key);
	}
}
