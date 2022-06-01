package com.mikhail.tarasevich.charcounter;

import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.CharCounterImpl;
import com.mikhail.tarasevich.charcounter.provider.HashMapToStringConverter;
import com.mikhail.tarasevich.charcounter.provider.HashMapToStringConverterImpl;
import com.mikhail.tarasevich.charcounter.validator.Validator;
import com.mikhail.tarasevich.charcounter.validator.ValidatorImpl;

public class ConsoleForCharCounterApplication {

	public static void main(String[] args) {
		Validator validator = new ValidatorImpl();
		CharCounter charCounter = new CharCounterImpl();
		HashMapToStringConverter hashMapToStringConverter = new HashMapToStringConverterImpl();
		
		CharCounterApplication ñharCounterApplication = new CharCounterApplication(validator, charCounter, hashMapToStringConverter);
		System.out.println(ñharCounterApplication.countCharactersInText("Alexey is real programmer"));
	}

}
