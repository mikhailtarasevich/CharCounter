import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mikhail.tarasevich.charcounter.CharCounterApplication;
import com.mikhail.tarasevich.charcounter.provider.CacheProviderImpl;
import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.CharCounterImpl;
import com.mikhail.tarasevich.charcounter.provider.ViewProvider;
import com.mikhail.tarasevich.charcounter.provider.ViewProviderImpl;
import com.mikhail.tarasevich.charcounter.provider.CacheProvider;
import com.mikhail.tarasevich.charcounter.provider.CacheProviderImpl;
import com.mikhail.tarasevich.charcounter.validator.Validator;
import com.mikhail.tarasevich.charcounter.validator.ValidatorImpl;

class CharCounterApplicationTest {
	
	Validator validator = new ValidatorImpl();
	CharCounter charCounter = new CharCounterImpl();
	ViewProviderImpl viewProviderImpl = new ViewProviderImpl();
	CacheProviderImpl<String, LinkedHashMap<Character, Long>> cacheProviderImpl = new CacheProviderImpl();
	CharCounterApplication charCounterApplication = new CharCounterApplication(validator, charCounter, viewProviderImpl, cacheProviderImpl);
	
	
	@Test
	public void countCharactersInText_inputIsString_expectedStringWithAmountOfUniqueCharacter() {
		assertThat(charCounterApplication.countCharactersInText("He 22")).isEqualTo("He 22" + "\n\"H\" = 1;\n\"e\" = 1;\n\" \" = 1;\n\"2\" = 2."); 
	}
	
	@Test
	public void countCharactersInText_inputIsNull_expectedException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			charCounterApplication.countCharactersInText(null);
		});
	}
}
