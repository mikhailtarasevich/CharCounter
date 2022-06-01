package com.mikhail.tarasevich.charcounter.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;

class ValidatorImplTest {

	ValidatorImpl validatorTest = new ValidatorImpl();

	@Test
	void validate_InputWhiteSpaces_ExpectedIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validatorTest.validate("         ");
		});
	}

	@Test
	void validate_InputIsEmpty_ExpecredIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validatorTest.validate("");
		});
	}

	@Test
	void validate_InputiSNull_ExpectedIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validatorTest.validate(null);
		});
	}

	@Test
	void validate_inputIsString_ExpectedNothing() {
		String text = "s345tgg l#";
		validatorTest.validate(text);
		assertThatCode(() ->validatorTest.validate(text)).doesNotThrowAnyException();
	}

}
