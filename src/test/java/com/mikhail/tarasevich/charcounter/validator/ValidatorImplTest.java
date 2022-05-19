package com.mikhail.tarasevich.charcounter.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;;

class ValidatorImplTest {

	final ValidatorImpl validatorTest = new ValidatorImpl();
	
	@Test
	void validate_InputWhiteSpaces_ExpectedIllegalArgumentException() {
		 assertThatThrownBy(() -> validatorTest.validate("         ")).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("Sentence is empty");
	}

	@Test
	void validate_InputiSNull_ExpectedIllegalArgumentException() {
		 assertThatThrownBy(() -> validatorTest.validate(null)).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("Sentence is null");
	}

	@Test
	void validate_inputIsString_ExpectedNothing() {
		assertThatCode(() ->validatorTest.validate("s345tgg l#")).doesNotThrowAnyException();
	}
}
