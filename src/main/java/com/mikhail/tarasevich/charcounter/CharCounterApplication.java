package com.mikhail.tarasevich.charcounter;

import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.HashMapToStringConverter;
import com.mikhail.tarasevich.charcounter.validator.Validator;

public class CharCounterApplication {

	private Validator validator;
	private CharCounter charCounter;
	private HashMapToStringConverter hashMapToStringConverter;
	
	public CharCounterApplication(Validator validator, CharCounter charCounter,
			HashMapToStringConverter hashMapToStringConverter) {
		this.validator = validator;
		this.charCounter = charCounter;
		this.hashMapToStringConverter = hashMapToStringConverter;
	}
	
	public String countCharactersInText(String text) {
		validator.validate(text);
		return hashMapToStringConverter.convertHashMapToString(charCounter.uniqueCharCounter(text), text);
	}
	
}
