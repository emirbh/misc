package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetKnockoutForward;
import fpml.consolidated.fx.targets.validation.FxTargetKnockoutForwardTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetKnockoutForwardValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetKnockoutForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetKnockoutForward.class)
public class FxTargetKnockoutForwardMeta implements RosettaMetaData<FxTargetKnockoutForward> {

	@Override
	public List<Validator<? super FxTargetKnockoutForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetKnockoutForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetKnockoutForward> validator(ValidatorFactory factory) {
		return factory.<FxTargetKnockoutForward>create(FxTargetKnockoutForwardValidator.class);
	}

	@Override
	public Validator<? super FxTargetKnockoutForward> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetKnockoutForward>create(FxTargetKnockoutForwardTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetKnockoutForward> validator() {
		return new FxTargetKnockoutForwardValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetKnockoutForward> typeFormatValidator() {
		return new FxTargetKnockoutForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetKnockoutForward, Set<String>> onlyExistsValidator() {
		return new FxTargetKnockoutForwardOnlyExistsValidator();
	}
}
