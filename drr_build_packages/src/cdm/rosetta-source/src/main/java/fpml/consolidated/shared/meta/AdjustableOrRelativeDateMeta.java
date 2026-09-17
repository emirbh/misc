package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.validation.AdjustableOrRelativeDateTypeFormatValidator;
import fpml.consolidated.shared.validation.AdjustableOrRelativeDateValidator;
import fpml.consolidated.shared.validation.datarule.AdjustableOrRelativeDateChoice;
import fpml.consolidated.shared.validation.exists.AdjustableOrRelativeDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustableOrRelativeDate.class)
public class AdjustableOrRelativeDateMeta implements RosettaMetaData<AdjustableOrRelativeDate> {

	@Override
	public List<Validator<? super AdjustableOrRelativeDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdjustableOrRelativeDate>create(AdjustableOrRelativeDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableOrRelativeDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableOrRelativeDate> validator(ValidatorFactory factory) {
		return factory.<AdjustableOrRelativeDate>create(AdjustableOrRelativeDateValidator.class);
	}

	@Override
	public Validator<? super AdjustableOrRelativeDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustableOrRelativeDate>create(AdjustableOrRelativeDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableOrRelativeDate> validator() {
		return new AdjustableOrRelativeDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustableOrRelativeDate> typeFormatValidator() {
		return new AdjustableOrRelativeDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOrRelativeDate, Set<String>> onlyExistsValidator() {
		return new AdjustableOrRelativeDateOnlyExistsValidator();
	}
}
