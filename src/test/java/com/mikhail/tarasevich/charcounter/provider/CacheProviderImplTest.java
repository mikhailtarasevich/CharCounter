package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

class CacheProviderImplTest {

	private final CacheProvider<String, LinkedHashMap<Character, Long>> cache = new CacheProviderImpl(2);

	@Test
	void getCache_inputMapCreatedWithCachableMethodAndMapCreatedWithPutMethod_expectedTheyAreEquals() {

		String str1 = "kkrrr4444";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<>();
		map1.put('k', 2L);
		map1.put('r', 3L);
		map1.put('4', 4L);

		String str2 = "gggggggttttrrr";
		LinkedHashMap<Character, Long> map2 = new LinkedHashMap<>();
		map2.put('g', 7L);
		map2.put('t', 4L);
		map2.put('r', 3L);

		LinkedHashMap<String, LinkedHashMap<Character, Long>> expectedLinkedHashMap = new LinkedHashMap<>(2);
		expectedLinkedHashMap.put(str1, map1);
		expectedLinkedHashMap.put(str2, map2);

		cache.put(str1, map1);
		cache.put(str2, map2);

		assertEquals(expectedLinkedHashMap.get(str1), cache.get(str1));
		assertEquals(expectedLinkedHashMap.get(str2), cache.get(str2));
	}

	@Test
	void getCache_inputMapCreatedWithCachableMethodWithOverloadingCacheAndMapCreatedWithPutMethod_expectedTheyAreEquals() {

		String str1 = "kkrrr4444";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<>();
		map1.put('k', 2L);
		map1.put('r', 3L);
		map1.put('4', 4L);

		String str2 = "gggggggttttrrr";
		LinkedHashMap<Character, Long> map2 = new LinkedHashMap<>();
		map2.put('g', 7L);
		map2.put('t', 4L);
		map2.put('r', 3L);

		LinkedHashMap<String, LinkedHashMap<Character, Long>> expectedLinkedHashMap = new LinkedHashMap<>(2);
		expectedLinkedHashMap.put(str2, map2);
		expectedLinkedHashMap.put(str1, map1);

		cache.put(str1, map1);
		cache.put(str2, map2);
		cache.put(str1, map1);

		assertEquals(expectedLinkedHashMap.get(str1), cache.get(str1));
		assertEquals(expectedLinkedHashMap.get(str2), cache.get(str2));
	}

	@Test
	void contains_cacheContainsKeyWhichTryingFind_expectedCacheContainsKeyTrue() {

		String str1 = "kkrrr4444";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<>();
		map1.put('k', 2L);
		map1.put('r', 3L);
		map1.put('4', 4L);

		cache.put(str1, map1);

		assertTrue(cache.contains(str1));
	}

	@Test
	void contains_cacheDoesNotContainKeyWhichTryingFind_expectedCacheContainsKeyFalse() {

		String str1 = "kkrrr4444";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<>();
		map1.put('k', 2L);
		map1.put('r', 3L);
		map1.put('4', 4L);

		cache.put(str1, map1);

		assertFalse(cache.contains("1"));
	}

	@Test
	void removeEldestEntry_inputOverloadCache_expectedCacheDoesNotContainRemovedKeys() {

		String str1 = "kkrrr4444";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<>();
		map1.put('k', 2L);
		map1.put('r', 3L);
		map1.put('4', 4L);

		String str2 = "gggggggttttrrr";
		LinkedHashMap<Character, Long> map2 = new LinkedHashMap<>();
		map2.put('g', 7L);
		map2.put('t', 4L);
		map2.put('r', 3L);

		String str3 = "rr";
		LinkedHashMap<Character, Long> map3 = new LinkedHashMap<>();
		map3.put('r', 2L);

		String str4 = "22";
		LinkedHashMap<Character, Long> map4 = new LinkedHashMap<>();
		map3.put('2', 2L);

		cache.put(str1, map1);
		cache.put(str2, map2);
		cache.put(str3, map3);
		cache.put(str4, map4);

		assertFalse(cache.contains(str1));
		assertFalse(cache.contains(str2));
	}
}
