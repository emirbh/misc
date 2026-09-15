package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import fpml.consolidated.eq.shared.validation.InterestLegResetDatesTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.InterestLegResetDatesValidator;
import fpml.consolidated.eq.shared.validation.datarule.InterestLegResetDatesChoice;
import fpml.consolidated.eq.shared.validation.exists.InterestLegResetDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestLegResetDates.class)
public class InterestLegResetDatesMeta implements RosettaMetaData<InterestLegResetDates> {

	@Override
	public List<Validator<? super InterestLegResetDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InterestLegResetDates>create(InterestLegResetDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestLegResetDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestLegResetDates> validator(ValidatorFactory factory) {
		return factory.<InterestLegResetDates>create(InterestLegResetDatesValidator.class);
	}

	@Override
	public Validator<? super InterestLegResetDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestLegResetDates>create(InterestLegResetDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestLegResetDates> validator() {
		return new InterestLegResetDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestLegResetDates> typeFormatValidator() {
		return new InterestLegResetDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestLegResetDates, Set<String>> onlyExistsValidator() {
		return new InterestLegResetDatesOnlyExistsValidator();
	}
}
