package com.mikhail.tarasevich.charcounter.provider;

public interface CacheProvider<K, V> {
	void put(K key, V value);
    V get(K key);
    boolean contains(K key);
}
