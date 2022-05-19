package com.mikhail.tarasevich.charcounter;

import java.util.Map;

public class HashMapPrinter {

	public void hashMapPrinter(Map<Character, Integer> hashMap) {
		hashMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		});
	}

}
