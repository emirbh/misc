package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CalculationPeriodDates;
import fpml.consolidated.ird.validation.CalculationPeriodDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.CalculationPeriodDatesValidator;
import fpml.consolidated.ird.validation.datarule.CalculationPeriodDatesChoice0;
import fpml.consolidated.ird.validation.datarule.CalculationPeriodDatesChoice1;
import fpml.consolidated.ird.validation.exists.CalculationPeriodDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationPeriodDates.class)
public class CalculationPeriodDatesMeta implements RosettaMetaData<CalculationPeriodDates> {

	@Override
	public List<Validator<? super CalculationPeriodDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesChoice0.class),
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodDates> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriodDates>create(CalculationPeriodDatesValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriodDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriodDates>create(CalculationPeriodDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodDates> validator() {
		return new CalculationPeriodDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodDates> typeFormatValidator() {
		return new CalculationPeriodDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodDates, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodDatesOnlyExistsValidator();
	}
}
