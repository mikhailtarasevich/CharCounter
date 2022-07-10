package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharCounterImplTest {

	CharCounterImpl charCounterImpl = new CharCounterImpl();
	String text;
	LinkedHashMap<Character, Long> expectedLinkedHashMap = new LinkedHashMap<Character, Long>();

	@Test
	void uniqueCharCounter_inputFromWordsSymbolsNumerals_expectedAmountOfUniqueCharacters() {
		
		expectedLinkedHashMap.put('H', 1l);
		expectedLinkedHashMap.put('e', 1l);
		expectedLinkedHashMap.put('l', 1l);
		expectedLinkedHashMap.put(' ', 1l);
		expectedLinkedHashMap.put('2', 2l);
		text = "Hel 22";
		assertEquals(expectedLinkedHashMap, charCounterImpl.uniqueCharCounter(text));
		
	}
	
	@Test
	void uniqueCharCounter_inputFromWhiteSpaces_expectedAmountOfWhiteSpaces() {
		
		expectedLinkedHashMap.put(' ', 4l);
		text = "    ";
		//assertEquals(expectedLinkedHashMap, charCounterImpl.uniqueCharCounter(text));
		assertTrue(expectedLinkedHashMap.entrySet().equals(charCounterImpl.uniqueCharCounter(text).entrySet()));
		
	}
	
	@Test
	void uniqueCharCounter_inputIsNull_expectedNullPointerException() {
		
		expectedLinkedHashMap.put(null, 1l);
		text = null;
		Assertions.assertThrows(NullPointerException.class, () -> {
			charCounterImpl.uniqueCharCounter(text);
		});
		
	}

}
