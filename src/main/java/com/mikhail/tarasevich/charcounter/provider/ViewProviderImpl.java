package com.mikhail.tarasevich.charcounter.provider;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class  ViewProviderImpl implements  ViewProvider {

	public String provideView(LinkedHashMap<Character, Long> hashMap, String text) {	    
		return hashMap.entrySet()
				.stream().map(entry -> "\"" + entry.getKey() + "\"" + " = " + entry.getValue())
				.collect(Collectors.joining(";" + "\n", text + "\n", "."));	
	}	
}
