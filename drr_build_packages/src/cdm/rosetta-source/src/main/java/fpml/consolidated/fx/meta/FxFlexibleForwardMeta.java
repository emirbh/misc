package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFlexibleForward;
import fpml.consolidated.fx.validation.FxFlexibleForwardTypeFormatValidator;
import fpml.consolidated.fx.validation.FxFlexibleForwardValidator;
import fpml.consolidated.fx.validation.exists.FxFlexibleForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFlexibleForward.class)
public class FxFlexibleForwardMeta implements RosettaMetaData<FxFlexibleForward> {

	@Override
	public List<Validator<? super FxFlexibleForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFlexibleForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFlexibleForward> validator(ValidatorFactory factory) {
		return factory.<FxFlexibleForward>create(FxFlexibleForwardValidator.class);
	}

	@Override
	public Validator<? super FxFlexibleForward> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFlexibleForward>create(FxFlexibleForwardTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFlexibleForward> validator() {
		return new FxFlexibleForwardValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFlexibleForward> typeFormatValidator() {
		return new FxFlexibleForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFlexibleForward, Set<String>> onlyExistsValidator() {
		return new FxFlexibleForwardOnlyExistsValidator();
	}
}
