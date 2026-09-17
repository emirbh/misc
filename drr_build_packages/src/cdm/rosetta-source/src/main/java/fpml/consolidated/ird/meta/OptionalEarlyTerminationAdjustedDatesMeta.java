package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.OptionalEarlyTerminationAdjustedDates;
import fpml.consolidated.ird.validation.OptionalEarlyTerminationAdjustedDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.OptionalEarlyTerminationAdjustedDatesValidator;
import fpml.consolidated.ird.validation.exists.OptionalEarlyTerminationAdjustedDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionalEarlyTerminationAdjustedDates.class)
public class OptionalEarlyTerminationAdjustedDatesMeta implements RosettaMetaData<OptionalEarlyTerminationAdjustedDates> {

	@Override
	public List<Validator<? super OptionalEarlyTerminationAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionalEarlyTerminationAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionalEarlyTerminationAdjustedDates> validator(ValidatorFactory factory) {
		return factory.<OptionalEarlyTerminationAdjustedDates>create(OptionalEarlyTerminationAdjustedDatesValidator.class);
	}

	@Override
	public Validator<? super OptionalEarlyTerminationAdjustedDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionalEarlyTerminationAdjustedDates>create(OptionalEarlyTerminationAdjustedDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionalEarlyTerminationAdjustedDates> validator() {
		return new OptionalEarlyTerminationAdjustedDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionalEarlyTerminationAdjustedDates> typeFormatValidator() {
		return new OptionalEarlyTerminationAdjustedDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionalEarlyTerminationAdjustedDates, Set<String>> onlyExistsValidator() {
		return new OptionalEarlyTerminationAdjustedDatesOnlyExistsValidator();
	}
}
