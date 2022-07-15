package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

class LRUCacheImplTest {

	LRUCacheImpl cache = new LRUCacheImpl(2);

	@Test
	void getCache_inputMapCreatedWithCachableMethodAndMapCreatedWithPutMethod_expectedTheyAreEquals() {

		String str1 = "kkrrr4444";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<Character, Long>();
		map1.put('k', 2l);
		map1.put('r', 3l);
		map1.put('4', 4l);

		String str2 = "gggggggttttrrr";
		LinkedHashMap<Character, Long> map2 = new LinkedHashMap<Character, Long>();
		map2.put('g', 7l);
		map2.put('t', 4l);
		map2.put('r', 3l);

		LinkedHashMap<String, LinkedHashMap<Character, Long>> expectedLinkedHashMap = new LinkedHashMap<String, LinkedHashMap<Character, Long>>(2);
		expectedLinkedHashMap.put(str1, map1);
		expectedLinkedHashMap.put(str2, map2);

		cache.cacheable(str1, map1);
		cache.cacheable(str2, map2);

		assertEquals(expectedLinkedHashMap, cache.getCache());
	}

	@Test
	void getCache_inputMapCreatedWithCachableMethodWithOverloadingCacheAndMapCreatedWithPutMethod_expectedTheyAreEquals() {

		String str1 = "kkrrr4444";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<Character, Long>();
		map1.put('k', 2l);
		map1.put('r', 3l);
		map1.put('4', 4l);

		String str2 = "gggggggttttrrr";
		LinkedHashMap<Character, Long> map2 = new LinkedHashMap<Character, Long>();
		map2.put('g', 7l);
		map2.put('t', 4l);
		map2.put('r', 3l);

		LinkedHashMap<String, LinkedHashMap<Character, Long>> expectedLinkedHashMap = new LinkedHashMap<String, LinkedHashMap<Character, Long>>(2);
		expectedLinkedHashMap.put(str2, map2);
		expectedLinkedHashMap.put(str1, map1);
		

		cache.cacheable(str1, map1);
		cache.cacheable(str2, map2);
		cache.cacheable(str1, map1);
		
		assertEquals(expectedLinkedHashMap, cache.getCache());
	}
		
}
