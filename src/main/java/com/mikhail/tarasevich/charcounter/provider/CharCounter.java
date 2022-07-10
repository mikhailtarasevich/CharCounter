package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;

public interface CharCounter {
	
	public LinkedHashMap<Character, Long> uniqueCharCounter(String text);
	
}
