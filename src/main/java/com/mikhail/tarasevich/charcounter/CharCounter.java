package com.mikhail.tarasevich.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {

	public Map<Character, Integer> countUniqueChars(String sentence) {

		validate(sentence);
			
		return uniqueCharCounter (sentence);
		
	}

	private void validate(String sentence) throws EmptyOrNullStringException {
		if (sentence == null) {
			throw new EmptyOrNullStringException("Sentence is null");
		}
		if (sentence.trim().isEmpty()) {
			throw new EmptyOrNullStringException("Sentence is empty");
		}
	}

	private Map<Character, Integer> uniqueCharCounter (String sentence) {
		char[] strToArray = sentence.toCharArray();
		Map<Character, Integer> hashMapOfUniqueCharacters = new HashMap<Character, Integer>();
		for (int i = 0; i < strToArray.length; i++){
			if (hashMapOfUniqueCharacters.get(strToArray[i]) == null){
				hashMapOfUniqueCharacters.put(strToArray[i], 1);
			} else {
				hashMapOfUniqueCharacters.replace(strToArray[i], hashMapOfUniqueCharacters.get(strToArray[i]) + 1);
			}
		}
		return hashMapOfUniqueCharacters;
	}
	
}
