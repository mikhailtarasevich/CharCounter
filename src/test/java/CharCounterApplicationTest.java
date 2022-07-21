
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import com.mikhail.tarasevich.charcounter.validator.Validator;
import com.mikhail.tarasevich.charcounter.validator.ValidatorImpl;

import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;


import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.CharCounterImpl;
import com.mikhail.tarasevich.charcounter.provider.ViewProvider;
import com.mikhail.tarasevich.charcounter.provider.ViewProviderImpl;
import com.mikhail.tarasevich.charcounter.CharCounterApplication;
import com.mikhail.tarasevich.charcounter.provider.CacheProvider;
import com.mikhail.tarasevich.charcounter.provider.CacheProviderImpl;
import com.mikhail.tarasevich.charcounter.validator.Validator;
import com.mikhail.tarasevich.charcounter.validator.ValidatorImpl;

class CharCounterApplicationTest {

	@Test
	public void countCharactersInText_inputIsStringValidatorIsNullCacheIsEmpty_expectedStringWithAmountOfUniqueCharacter() {
		Validator validator = mock(ValidatorImpl.class);
		CharCounter charCounter = mock(CharCounterImpl.class);
		ViewProvider viewProvider = mock(ViewProviderImpl.class);
		CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider = mock(CacheProviderImpl.class);

		CharCounterApplication charCounterApplication = new CharCounterApplication(validator, charCounter, viewProvider,
				cacheProvider);

		String text = "hi";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<Character, Long>();
		map1.put('h', 1L);
		map1.put('i', 2L);

		when(cacheProvider.contains(text)).thenReturn(false);
		when(charCounter.uniqueCharCounter("hi")).thenReturn(map1);
		when(viewProvider.provideView(map1, text)).thenReturn("Hi" + "\n\"H\" = 1;\n\"i\" = 1.");

		assertEquals(charCounterApplication.countCharactersInText(text), "Hi" + "\n\"H\" = 1;\n\"i\" = 1.");
	}

	@Test
	public void countCharactersInText_inputIsStringValidatorIsNullCacheContainsString_expectedStringWithAmountOfUniqueCharacterFromCache() {
		Validator validator = mock(ValidatorImpl.class);
		CharCounter charCounter = mock(CharCounterImpl.class);
		ViewProvider viewProvider = mock(ViewProviderImpl.class);
		CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider = mock(CacheProviderImpl.class);

		CharCounterApplication charCounterApplication = new CharCounterApplication(validator, charCounter, viewProvider,
				cacheProvider);

		String text = "hi";
		LinkedHashMap<Character, Long> map1 = new LinkedHashMap<Character, Long>();
		map1.put('h', 1L);
		map1.put('i', 2L);

		when(cacheProvider.contains(text)).thenReturn(true);
		when(cacheProvider.get(text)).thenReturn(map1);
		when(viewProvider.provideView(cacheProvider.get(text), text)).thenReturn("Hi" + "\n\"H\" = 1;\n\"i\" = 1.");

		assertEquals(charCounterApplication.countCharactersInText(text), "Hi" + "\n\"H\" = 1;\n\"i\" = 1.");
	}

	@Test
	public void countCharactersInText_inputIsNullOrEmptyString_expectedException() {
		Validator validator = mock(ValidatorImpl.class);
		CharCounter charCounter = mock(CharCounterImpl.class);
		ViewProvider viewProvider = mock(ViewProviderImpl.class);
		CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider = mock(CacheProviderImpl.class);

		CharCounterApplication charCounterApplication = new CharCounterApplication(validator, charCounter, viewProvider,
				cacheProvider);

		String text = " ";

		doThrow(new IllegalArgumentException()).when(validator).validate(text);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			charCounterApplication.countCharactersInText(text);
		});

	}
}
