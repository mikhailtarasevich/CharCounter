package com.mikhail.tarasevich.charcounter;


import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.HashMapToStringConverter;
import com.mikhail.tarasevich.charcounter.provider.LRUCache;
import com.mikhail.tarasevich.charcounter.provider.LRUCacheImpl;
import com.mikhail.tarasevich.charcounter.validator.Validator;

public class CharCounterApplication {

	private Validator validator;
	private CharCounter charCounter;
	private HashMapToStringConverter hashMapToStringConverter;
	private LRUCache lRUCache;

	public CharCounterApplication(Validator validator, CharCounter charCounter,
			HashMapToStringConverter hashMapToStringConverter, LRUCache lRUCache) {
		this.validator = validator;
		this.charCounter = charCounter;
		this.hashMapToStringConverter = hashMapToStringConverter;
		this.lRUCache = lRUCache;
	}

	public String countCharactersInText(String text) {
		validator.validate(text);
		if (lRUCache.getCache().containsKey(text)) {
			lRUCache.cacheable(text, lRUCache.getCache().get(text));
			return hashMapToStringConverter.convertHashMapToString(lRUCache.getCache().get(text), text);
		}else {
			lRUCache.cacheable(text, charCounter.uniqueCharCounter(text));
			}			
		return hashMapToStringConverter.convertHashMapToString(lRUCache.getCache().get(text), text);
	}
	
}
