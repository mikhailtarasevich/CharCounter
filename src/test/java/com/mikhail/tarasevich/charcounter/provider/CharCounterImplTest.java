package com.mikhail.tarasevich.charcounter.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class CharCounterImplTest {

	private final CharCounter charCounterImpl = new CharCounterImpl();
	String text;
	private final LinkedHashMap<Character, Long> expectedLinkedHashMap = new LinkedHashMap<>();

	@Test
	void uniqueCharCounter_inputFromWordsSymbolsNumerals_expectedAmountOfUniqueCharacters() {
		expectedLinkedHashMap.put('H', 1L);
		expectedLinkedHashMap.put('e', 1L);
		expectedLinkedHashMap.put('l', 1L);
		expectedLinkedHashMap.put(' ', 1L);
		expectedLinkedHashMap.put('2', 2L);
		text = "Hel 22";
		
		assertEquals(expectedLinkedHashMap, charCounterImpl.uniqueCharCounter(text));
	}

	@Test
	void uniqueCharCounter_inputIsNull_expectedNullPointerException() {
		expectedLinkedHashMap.put(null, 1L);
		text = null;
		
		assertThrows(NullPointerException.class, () -> charCounterImpl.uniqueCharCounter(text));		
	}
}
