package com.mikhail.tarasevich.charcounter.validator;

public class ValidatorImpl implements Validator {

	public void validate(String text){
		if (text == null) {
			throw new IllegalArgumentException("Sentence is null");
		}
		if (text.trim().isEmpty()) {
			throw new IllegalArgumentException("Sentence is empty");
		}
	}
}
