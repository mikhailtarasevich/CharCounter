package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

class HashMapToStringConverterImplTest {

	HashMapToStringConverterImpl hashMapToStringConverterImpl = new HashMapToStringConverterImpl();
	String inputString;
	String expectedString;
	LinkedHashMap<Character, Integer> inputHashMap = new LinkedHashMap<Character, Integer>();

	@Test
	void convertHashMapToString_inputHashMapWithAmountOfUniqueCharacter_expectedStringWithAmountOfUniqueCharacter() {
		inputString = "Hello 22";
		inputHashMap.put('H', 1);
		inputHashMap.put('e', 1);
		inputHashMap.put('l', 2);
		inputHashMap.put('o', 1);
		inputHashMap.put(' ', 1);
		inputHashMap.put('2', 2);		
		expectedString = inputString + "\n" + "\"" + "H" + "\"" + " = 1" + "\n" + "\"" + "e" + "\"" + " = 1" + "\n" + "\"" + "l" + "\"" + " = 2" + "\n" + "\"" + "o" + "\"" + " = 1" + "\n" + "\"" + " " + "\"" + " = 1" + "\n" + "\"" + "2" + "\"" + " = 2";
		assertEquals(expectedString, hashMapToStringConverterImpl.convertHashMapToString(inputHashMap, inputString));
		
	}
	
}
