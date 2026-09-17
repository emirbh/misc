package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.validation.AdjustableOrRelativeDatesTypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustableOrRelativeDatesValidator;
import fpml.consolidated.shared.validation.datarule.AdjustableOrRelativeDatesChoice;
import fpml.consolidated.shared.validation.exists.AdjustableOrRelativeDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableOrRelativeDates.class)
public class AdjustableOrRelativeDatesMeta implements RosettaMetaData<AdjustableOrRelativeDates> {

	@Override
	public List<Validator<? super AdjustableOrRelativeDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableOrRelativeDates>create(AdjustableOrRelativeDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableOrRelativeDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableOrRelativeDates> validator(ValidatorFactory factory) {
		return factory.<AdjustableOrRelativeDates>create(AdjustableOrRelativeDatesValidator.class);
	}

	@Override
	public Validator<? super AdjustableOrRelativeDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableOrRelativeDates>create(AdjustableOrRelativeDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableOrRelativeDates> validator() {
		return new AdjustableOrRelativeDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableOrRelativeDates> typeFormatValidator() {
		return new AdjustableOrRelativeDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOrRelativeDates, Set<String>> onlyExistsValidator() {
		return new AdjustableOrRelativeDatesOnlyExistsValidator();
	}
}
