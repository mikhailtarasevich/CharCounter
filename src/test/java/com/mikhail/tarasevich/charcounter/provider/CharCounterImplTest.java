package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharCounterImplTest {

	CharCounterImpl charCounterImpl = new CharCounterImpl();
	String text;
	LinkedHashMap<Character, Integer> expectedLinkedHashMap = new LinkedHashMap<Character, Integer>();

	@Test
	void uniqueCharCounter_inputFromWordsSymbolsNumerals_expectedAmountOfUniqueCharacters() {
		
		expectedLinkedHashMap.put('H', 1);
		expectedLinkedHashMap.put('e', 1);
		expectedLinkedHashMap.put('l', 2);
		expectedLinkedHashMap.put('o', 1);
		expectedLinkedHashMap.put(' ', 1);
		expectedLinkedHashMap.put('2', 2);
		text = "Hello 22";
		assertEquals(expectedLinkedHashMap, charCounterImpl.uniqueCharCounter(text));
		
	}
	
	@Test
	void uniqueCharCounter_inputFromWhiteSpaces_expectedAmountOfWhiteSpaces() {
		
		expectedLinkedHashMap.put(' ', 5);
		text = "     ";
		assertEquals(expectedLinkedHashMap, charCounterImpl.uniqueCharCounter(text));
		
	}
	
	@Test
	void uniqueCharCounter_inputIsNull_expectedNullPointerException() {
		
		expectedLinkedHashMap.put(null, 1);
		text = null;
		Assertions.assertThrows(NullPointerException.class, () -> {
			charCounterImpl.uniqueCharCounter(text);
		});
		
	}

}
