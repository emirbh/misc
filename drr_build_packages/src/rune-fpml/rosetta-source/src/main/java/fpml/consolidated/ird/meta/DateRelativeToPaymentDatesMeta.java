package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.DateRelativeToPaymentDates;
import fpml.consolidated.ird.validation.DateRelativeToPaymentDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.DateRelativeToPaymentDatesValidator;
import fpml.consolidated.ird.validation.exists.DateRelativeToPaymentDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DateRelativeToPaymentDates.class)
public class DateRelativeToPaymentDatesMeta implements RosettaMetaData<DateRelativeToPaymentDates> {

	@Override
	public List<Validator<? super DateRelativeToPaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateRelativeToPaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DateRelativeToPaymentDates> validator(ValidatorFactory factory) {
		return factory.<DateRelativeToPaymentDates>create(DateRelativeToPaymentDatesValidator.class);
	}

	@Override
	public Validator<? super DateRelativeToPaymentDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DateRelativeToPaymentDates>create(DateRelativeToPaymentDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DateRelativeToPaymentDates> validator() {
		return new DateRelativeToPaymentDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DateRelativeToPaymentDates> typeFormatValidator() {
		return new DateRelativeToPaymentDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateRelativeToPaymentDates, Set<String>> onlyExistsValidator() {
		return new DateRelativeToPaymentDatesOnlyExistsValidator();
	}
}
