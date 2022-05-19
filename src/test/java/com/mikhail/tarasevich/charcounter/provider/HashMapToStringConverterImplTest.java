package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

class HashMapToStringConverterImplTest {

	private final ViewProvider viewProvider = new ViewProviderImpl();
	String inputString;
	String expectedString;
	private final LinkedHashMap<Character, Long> inputHashMap = new LinkedHashMap<>();

	@Test
	void convertHashMapToString_inputHashMapWithAmountOfUniqueCharacter_expectedStringWithAmountOfUniqueCharacter() {
		inputString = "Hello 22";
		inputHashMap.put('H', 1L);
		inputHashMap.put('e', 1L);
		inputHashMap.put('l', 2L);
		inputHashMap.put('o', 1L);
		inputHashMap.put(' ', 1L);
		inputHashMap.put('2', 2L);		
		expectedString = inputString + "\n\"H\" = 1;\n\"e\" = 1;\n\"l\" = 2;\n\"o\" = 1;\n\" \" = 1;\n\"2\" = 2.";
		
		assertEquals(expectedString, viewProvider.provideView(inputHashMap, inputString));		
	}	
}
