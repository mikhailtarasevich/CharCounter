package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

class HashMapToStringConverterImplTest {

	ViewProviderImpl viewProviderImpl = new ViewProviderImpl();
	String inputString;
	String expectedString;
	LinkedHashMap<Character, Long> inputHashMap = new LinkedHashMap<Character, Long>();

	@Test
	void convertHashMapToString_inputHashMapWithAmountOfUniqueCharacter_expectedStringWithAmountOfUniqueCharacter() {
		inputString = "Hello 22";
		inputHashMap.put('H', 1l);
		inputHashMap.put('e', 1l);
		inputHashMap.put('l', 2l);
		inputHashMap.put('o', 1l);
		inputHashMap.put(' ', 1l);
		inputHashMap.put('2', 2l);		
		expectedString = inputString + "\n\"H\" = 1;\n\"e\" = 1;\n\"l\" = 2;\n\"o\" = 1;\n\" \" = 1;\n\"2\" = 2.";
		assertEquals(expectedString, viewProviderImpl.provideView(inputHashMap, inputString));
		
	}
	
}
