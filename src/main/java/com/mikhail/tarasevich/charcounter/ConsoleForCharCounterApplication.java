package com.mikhail.tarasevich.charcounter;

import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.CharCounterImpl;
import com.mikhail.tarasevich.charcounter.provider.ViewProvider;
import com.mikhail.tarasevich.charcounter.provider.ViewProviderImpl;

import java.util.LinkedHashMap;
import com.mikhail.tarasevich.charcounter.provider.CacheProvider;
import com.mikhail.tarasevich.charcounter.provider.CacheProviderImpl;
import com.mikhail.tarasevich.charcounter.validator.Validator;
import com.mikhail.tarasevich.charcounter.validator.ValidatorImpl;

public class ConsoleForCharCounterApplication {

	public static void main(String[] args) {
		Validator validator = new ValidatorImpl();
		CharCounter charCounter = new CharCounterImpl();
		ViewProvider viewProvider = new ViewProviderImpl();
		CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider = new CacheProviderImpl(2);

		CharCounterApplication charCounterApplication = new CharCounterApplication(validator, charCounter, viewProvider, cacheProvider);

		System.out.println(charCounterApplication.countCharactersInText("2222 22"));
		System.out.println(charCounterApplication.countCharactersInText("Hello 22"));
		System.out.println(charCounterApplication.countCharactersInText("dfg 22"));
		System.out.println(charCounterApplication.countCharactersInText("Hello 22"));
	}
}
