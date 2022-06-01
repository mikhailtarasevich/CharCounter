package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

public class CharCounterImpl implements CharCounter {

	public LinkedHashMap<Character, Integer> uniqueCharCounter (String text) {
		char[] strToArray = text.toCharArray();
		LinkedHashMap<Character, Integer> linkedHashMapOfUniqueCharacters = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < strToArray.length; i++){
			if (linkedHashMapOfUniqueCharacters.get(strToArray[i]) == null){
				linkedHashMapOfUniqueCharacters.put(strToArray[i], 1);
			} else {
				linkedHashMapOfUniqueCharacters.replace(strToArray[i], linkedHashMapOfUniqueCharacters.get(strToArray[i]) + 1);
			}
		}
		return linkedHashMapOfUniqueCharacters;
	}
	
}
