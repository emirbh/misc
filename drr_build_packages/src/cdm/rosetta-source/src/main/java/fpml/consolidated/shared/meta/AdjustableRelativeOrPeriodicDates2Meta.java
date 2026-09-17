package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import fpml.consolidated.shared.validation.AdjustableRelativeOrPeriodicDates2TypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustableRelativeOrPeriodicDates2Validator;
import fpml.consolidated.shared.validation.datarule.AdjustableRelativeOrPeriodicDates2Choice;
import fpml.consolidated.shared.validation.exists.AdjustableRelativeOrPeriodicDates2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableRelativeOrPeriodicDates2.class)
public class AdjustableRelativeOrPeriodicDates2Meta implements RosettaMetaData<AdjustableRelativeOrPeriodicDates2> {

	@Override
	public List<Validator<? super AdjustableRelativeOrPeriodicDates2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableRelativeOrPeriodicDates2>create(AdjustableRelativeOrPeriodicDates2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableRelativeOrPeriodicDates2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates2> validator(ValidatorFactory factory) {
		return factory.<AdjustableRelativeOrPeriodicDates2>create(AdjustableRelativeOrPeriodicDates2Validator.class);
	}

	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableRelativeOrPeriodicDates2>create(AdjustableRelativeOrPeriodicDates2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates2> validator() {
		return new AdjustableRelativeOrPeriodicDates2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates2> typeFormatValidator() {
		return new AdjustableRelativeOrPeriodicDates2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableRelativeOrPeriodicDates2, Set<String>> onlyExistsValidator() {
		return new AdjustableRelativeOrPeriodicDates2OnlyExistsValidator();
	}
}
