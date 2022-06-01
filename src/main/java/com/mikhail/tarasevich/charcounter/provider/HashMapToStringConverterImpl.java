package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

public class HashMapToStringConverterImpl implements HashMapToStringConverter {

	public String convertHashMapToString(LinkedHashMap<Character, Integer> map, String text) {
	    StringBuilder mapAsString = new StringBuilder(text);
	    for (Character key : map.keySet()) {
	        mapAsString.append("\n" + "\"" + key + "\"" + " = " + map.get(key));
	    }
	    return mapAsString.toString();
	}

}
