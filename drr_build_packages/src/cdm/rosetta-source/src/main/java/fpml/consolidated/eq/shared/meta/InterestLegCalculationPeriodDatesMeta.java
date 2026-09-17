package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDates;
import fpml.consolidated.eq.shared.validation.InterestLegCalculationPeriodDatesTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.InterestLegCalculationPeriodDatesValidator;
import fpml.consolidated.eq.shared.validation.exists.InterestLegCalculationPeriodDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestLegCalculationPeriodDates.class)
public class InterestLegCalculationPeriodDatesMeta implements RosettaMetaData<InterestLegCalculationPeriodDates> {

	@Override
	public List<Validator<? super InterestLegCalculationPeriodDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestLegCalculationPeriodDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestLegCalculationPeriodDates> validator(ValidatorFactory factory) {
		return factory.<InterestLegCalculationPeriodDates>create(InterestLegCalculationPeriodDatesValidator.class);
	}

	@Override
	public Validator<? super InterestLegCalculationPeriodDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestLegCalculationPeriodDates>create(InterestLegCalculationPeriodDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestLegCalculationPeriodDates> validator() {
		return new InterestLegCalculationPeriodDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestLegCalculationPeriodDates> typeFormatValidator() {
		return new InterestLegCalculationPeriodDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestLegCalculationPeriodDates, Set<String>> onlyExistsValidator() {
		return new InterestLegCalculationPeriodDatesOnlyExistsValidator();
	}
}
