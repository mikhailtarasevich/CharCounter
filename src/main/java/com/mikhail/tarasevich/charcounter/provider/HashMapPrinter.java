package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

public class HashMapPrinter {

	public void hashMapPrinter(LinkedHashMap<Character, Integer> hashMap) {
		hashMap.entrySet().forEach(entry -> {
			System.out.println("\"" + entry.getKey() + "\"" + " " + " = " + entry.getValue());
		});
	}

}
