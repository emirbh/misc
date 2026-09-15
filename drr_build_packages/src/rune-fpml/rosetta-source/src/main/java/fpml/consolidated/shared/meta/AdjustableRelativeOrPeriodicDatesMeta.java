package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.validation.AdjustableRelativeOrPeriodicDatesTypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustableRelativeOrPeriodicDatesValidator;
import fpml.consolidated.shared.validation.datarule.AdjustableRelativeOrPeriodicDatesChoice;
import fpml.consolidated.shared.validation.exists.AdjustableRelativeOrPeriodicDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableRelativeOrPeriodicDates.class)
public class AdjustableRelativeOrPeriodicDatesMeta implements RosettaMetaData<AdjustableRelativeOrPeriodicDates> {

	@Override
	public List<Validator<? super AdjustableRelativeOrPeriodicDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableRelativeOrPeriodicDates>create(AdjustableRelativeOrPeriodicDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableRelativeOrPeriodicDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates> validator(ValidatorFactory factory) {
		return factory.<AdjustableRelativeOrPeriodicDates>create(AdjustableRelativeOrPeriodicDatesValidator.class);
	}

	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableRelativeOrPeriodicDates>create(AdjustableRelativeOrPeriodicDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates> validator() {
		return new AdjustableRelativeOrPeriodicDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates> typeFormatValidator() {
		return new AdjustableRelativeOrPeriodicDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableRelativeOrPeriodicDates, Set<String>> onlyExistsValidator() {
		return new AdjustableRelativeOrPeriodicDatesOnlyExistsValidator();
	}
}
