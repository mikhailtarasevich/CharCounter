package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

public interface LRUCache {
	public void cacheable(String key, LinkedHashMap<Character, Long> data);
}
