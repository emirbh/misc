package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.DateRelativeToCalculationPeriodDates;
import fpml.consolidated.ird.validation.DateRelativeToCalculationPeriodDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.DateRelativeToCalculationPeriodDatesValidator;
import fpml.consolidated.ird.validation.exists.DateRelativeToCalculationPeriodDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DateRelativeToCalculationPeriodDates.class)
public class DateRelativeToCalculationPeriodDatesMeta implements RosettaMetaData<DateRelativeToCalculationPeriodDates> {

	@Override
	public List<Validator<? super DateRelativeToCalculationPeriodDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateRelativeToCalculationPeriodDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DateRelativeToCalculationPeriodDates> validator(ValidatorFactory factory) {
		return factory.<DateRelativeToCalculationPeriodDates>create(DateRelativeToCalculationPeriodDatesValidator.class);
	}

	@Override
	public Validator<? super DateRelativeToCalculationPeriodDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DateRelativeToCalculationPeriodDates>create(DateRelativeToCalculationPeriodDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DateRelativeToCalculationPeriodDates> validator() {
		return new DateRelativeToCalculationPeriodDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DateRelativeToCalculationPeriodDates> typeFormatValidator() {
		return new DateRelativeToCalculationPeriodDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateRelativeToCalculationPeriodDates, Set<String>> onlyExistsValidator() {
		return new DateRelativeToCalculationPeriodDatesOnlyExistsValidator();
	}
}
