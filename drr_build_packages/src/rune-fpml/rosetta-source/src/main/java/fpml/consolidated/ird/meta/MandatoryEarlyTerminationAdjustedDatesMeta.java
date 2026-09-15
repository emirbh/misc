package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.MandatoryEarlyTerminationAdjustedDates;
import fpml.consolidated.ird.validation.MandatoryEarlyTerminationAdjustedDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.MandatoryEarlyTerminationAdjustedDatesValidator;
import fpml.consolidated.ird.validation.exists.MandatoryEarlyTerminationAdjustedDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MandatoryEarlyTerminationAdjustedDates.class)
public class MandatoryEarlyTerminationAdjustedDatesMeta implements RosettaMetaData<MandatoryEarlyTerminationAdjustedDates> {

	@Override
	public List<Validator<? super MandatoryEarlyTerminationAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MandatoryEarlyTerminationAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MandatoryEarlyTerminationAdjustedDates> validator(ValidatorFactory factory) {
		return factory.<MandatoryEarlyTerminationAdjustedDates>create(MandatoryEarlyTerminationAdjustedDatesValidator.class);
	}

	@Override
	public Validator<? super MandatoryEarlyTerminationAdjustedDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MandatoryEarlyTerminationAdjustedDates>create(MandatoryEarlyTerminationAdjustedDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryEarlyTerminationAdjustedDates> validator() {
		return new MandatoryEarlyTerminationAdjustedDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryEarlyTerminationAdjustedDates> typeFormatValidator() {
		return new MandatoryEarlyTerminationAdjustedDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryEarlyTerminationAdjustedDates, Set<String>> onlyExistsValidator() {
		return new MandatoryEarlyTerminationAdjustedDatesOnlyExistsValidator();
	}
}
