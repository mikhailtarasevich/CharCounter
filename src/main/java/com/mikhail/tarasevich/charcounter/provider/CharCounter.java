package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

import com.mikhail.tarasevich.charcounter.validator.EmptyOrNullStringException;

public class CharCounter {

	public LinkedHashMap<Character, Integer> countUniqueChars(String sentence) {

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

	private LinkedHashMap<Character, Integer> uniqueCharCounter (String sentence) {
		char[] strToArray = sentence.toCharArray();
		LinkedHashMap<Character, Integer> hashMapOfUniqueCharacters = new LinkedHashMap<Character, Integer>();
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
