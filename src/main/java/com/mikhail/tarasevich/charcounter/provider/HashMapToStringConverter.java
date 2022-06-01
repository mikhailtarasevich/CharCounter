package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

public interface HashMapToStringConverter {

	public String convertHashMapToString(LinkedHashMap<Character, Integer> map, String text);
	
}
