import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mikhail.tarasevich.charcounter.CharCounterApplication;
import com.mikhail.tarasevich.charcounter.provider.CharCounter;
import com.mikhail.tarasevich.charcounter.provider.CharCounterImpl;
import com.mikhail.tarasevich.charcounter.provider.HashMapToStringConverter;
import com.mikhail.tarasevich.charcounter.provider.HashMapToStringConverterImpl;
import com.mikhail.tarasevich.charcounter.validator.Validator;
import com.mikhail.tarasevich.charcounter.validator.ValidatorImpl;

class CharCounterApplicationTest {
	
	Validator validator = new ValidatorImpl();
	CharCounter charCounter = new CharCounterImpl();
	HashMapToStringConverter hashMapToStringConverter = new HashMapToStringConverterImpl();
	CharCounterApplication ñharCounterApplication = new CharCounterApplication(validator, charCounter, hashMapToStringConverter);
	
	
	@Test
	public void countCharactersInText_inputIsString_expectedStringWithAmountOfUniqueCharacter() {
		assertThat(ñharCounterApplication.countCharactersInText("He 22")).isEqualTo("He 22" + "\n" + "\"" + "H" + "\"" + " = 1" + "\n" + "\"" + "e" + "\"" + " = 1" + "\n" + "\"" + " " + "\"" + " = 1" + "\n" + "\"" + "2" + "\"" + " = 2"); 
	}
	
	@Test
	public void countCharactersInText_inputIsNull_expectedException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ñharCounterApplication.countCharactersInText(null);
		});
	}
}
