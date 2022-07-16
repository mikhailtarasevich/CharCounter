package com.mikhail.tarasevich.charcounter;


import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider. ViewProvider;

import java.util.LinkedHashMap;

import com.mikhail.tarasevich.charcounter.provider.CacheProvider;
import com.mikhail.tarasevich.charcounter.validator.Validator;

public class CharCounterApplication {

	private Validator validator;
	private CharCounter charCounter;
	private ViewProvider  viewProvider;
	private CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider;

	public CharCounterApplication(Validator validator, CharCounter charCounter,
			 ViewProvider  viewProvider, CacheProvider cacheProvider) {
		this.validator = validator;
		this.charCounter = charCounter;
		this.viewProvider = viewProvider;
		this.cacheProvider = cacheProvider;
	}

	public String countCharactersInText(String text) {
		validator.validate(text);
		if (cacheProvider.contains(text)) {
	
			return viewProvider.provideView(cacheProvider.get(text), text);
		}else {
			cacheProvider.put(text, charCounter.uniqueCharCounter(text));
			}			
		return viewProvider.provideView(cacheProvider.get(text), text);
	}
	
}
