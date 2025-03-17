package se.sundsvall.invoicesender.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Stream;

public class ValidStatusConstraintValidator implements ConstraintValidator<ValidStatus, String> {

	private List<String> acceptedValues;

	@Override
	public void initialize(final ValidStatus constraintAnnotation) {
		acceptedValues = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
			.map(Enum::name)
			.toList();
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context) {

		if (acceptedValues.contains(value.toUpperCase())) {
			return true;
		}

		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate("status must be one of: %s".formatted(acceptedValues.toString()))
			.addConstraintViolation();
		return false;
	}
}
