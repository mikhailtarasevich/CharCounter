
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.ViewProvider;
import com.mikhail.tarasevich.charcounter.CharCounterApplication;
import com.mikhail.tarasevich.charcounter.provider.CacheProvider;
import com.mikhail.tarasevich.charcounter.validator.Validator;

@ExtendWith( MockitoExtension.class)
class CharCounterApplicationTest {

	@InjectMocks
	private CharCounterApplication charCounterApplication;
	
	@Mock
	private Validator validator;
	@Mock
	private CharCounter charCounter;
	@Mock
	private ViewProvider viewProvider;
	@Mock
	private CacheProvider<String, LinkedHashMap<Character, Long>> cacheProvider;

	@Test
	void countCharactersInText_inputIsStringValidatorIsNullCacheIsEmpty_expectedStringWithAmountOfUniqueCharacter() {

		String text = "hi";
		final LinkedHashMap<Character, Long> map1 = new LinkedHashMap<Character, Long>();
		map1.put('h', 1L);
		map1.put('i', 2L);
		
		doNothing().when(validator).validate(text);
		when(cacheProvider.contains(text)).thenReturn(false);
		when(charCounter.uniqueCharCounter(text)).thenReturn(map1);
		when(viewProvider.provideView(map1, text)).thenReturn("Hi" + "\n\"H\" = 1;\n\"i\" = 1.");
	
		assertEquals(charCounterApplication.countCharactersInText(text), "Hi" + "\n\"H\" = 1;\n\"i\" = 1.");
		
		verify(validator).validate(text);
		verify(cacheProvider).contains(text);
		verify(charCounter).uniqueCharCounter(text);
		verify(viewProvider).provideView(map1, text);
	}

	@Test
	void countCharactersInText_inputIsStringValidatorIsNullCacheContainsString_expectedStringWithAmountOfUniqueCharacterFromCache() {

		String text = "hi";
		final LinkedHashMap<Character, Long> map1 = new LinkedHashMap<Character, Long>();
		map1.put('h', 1L);
		map1.put('i', 2L);
		
		doNothing().when(validator).validate(text);
		when(cacheProvider.contains(text)).thenReturn(true);
		when(cacheProvider.get(text)).thenReturn(map1);
		when(viewProvider.provideView(map1, text)).thenReturn("Hi" + "\n\"H\" = 1;\n\"i\" = 1.");
		
		assertEquals(charCounterApplication.countCharactersInText(text), "Hi" + "\n\"H\" = 1;\n\"i\" = 1.");
		
		verify(validator).validate(text);
		verify(cacheProvider).contains(text);
		verify(cacheProvider).get(text);
		verify(viewProvider).provideView(map1, text);
	}

	@Test
	void countCharactersInText_inputIsNullOrEmptyString_expectedException() {
		String text = " ";
		doThrow(new IllegalArgumentException()).when(validator).validate(text);
		assertThrows(IllegalArgumentException.class, () -> charCounterApplication.countCharactersInText(text));
		verify(validator).validate(text);
		verifyNoMoreInteractions(cacheProvider, charCounter, viewProvider);
	}
}
