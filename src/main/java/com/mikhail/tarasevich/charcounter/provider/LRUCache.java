package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public interface LRUCache {
	public void cacheable(String key, LinkedHashMap<Character, Long> data);
	public Map<String, LinkedHashMap<Character, Long>> getCache();
}
