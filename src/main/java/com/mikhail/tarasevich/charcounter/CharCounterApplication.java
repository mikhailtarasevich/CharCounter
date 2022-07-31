package com.mikhail.tarasevich.charcounter;

import java.util.LinkedHashMap;

import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.ViewProvider;
import com.mikhail.tarasevich.charcounter.provider.CacheProvider;
import com.mikhail.tarasevich.charcounter.validator.Validator;

public class CharCounterApplication {
	private final Validator validator;
	private final CharCounter charCounter;
	private final ViewProvider viewProvider;
	private final CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider;

	public CharCounterApplication(Validator validator, CharCounter charCounter, ViewProvider viewProvider,
			CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider) {
		this.validator = validator;
		this.charCounter = charCounter;
		this.viewProvider = viewProvider;
		this.cacheProvider = cacheProvider;
	}

	public String countCharactersInText(String text) {
		LinkedHashMap<Character, Long> result;
		validator.validate(text);
		if (cacheProvider.contains(text)) {
			return viewProvider.provideView(cacheProvider.get(text), text);
		} else {
			result = charCounter.uniqueCharCounter(text);
			cacheProvider.put(text, result);
			return viewProvider.provideView(result, text);
		}
	}
}
