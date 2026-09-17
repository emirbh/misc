package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.validation.AdjustableDatesTypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustableDatesValidator;
import fpml.consolidated.shared.validation.exists.AdjustableDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableDates.class)
public class AdjustableDatesMeta implements RosettaMetaData<AdjustableDates> {

	@Override
	public List<Validator<? super AdjustableDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustableDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableDates> validator(ValidatorFactory factory) {
		return factory.<AdjustableDates>create(AdjustableDatesValidator.class);
	}

	@Override
	public Validator<? super AdjustableDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableDates>create(AdjustableDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDates> validator() {
		return new AdjustableDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableDates> typeFormatValidator() {
		return new AdjustableDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDates, Set<String>> onlyExistsValidator() {
		return new AdjustableDatesOnlyExistsValidator();
	}
}
