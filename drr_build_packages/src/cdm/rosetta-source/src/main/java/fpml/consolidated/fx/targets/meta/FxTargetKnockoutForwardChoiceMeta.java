package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetKnockoutForwardChoice;
import fpml.consolidated.fx.targets.validation.FxTargetKnockoutForwardChoiceTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetKnockoutForwardChoiceValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetKnockoutForwardChoiceChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetKnockoutForwardChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetKnockoutForwardChoice.class)
public class FxTargetKnockoutForwardChoiceMeta implements RosettaMetaData<FxTargetKnockoutForwardChoice> {

	@Override
	public List<Validator<? super FxTargetKnockoutForwardChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetKnockoutForwardChoice>create(FxTargetKnockoutForwardChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetKnockoutForwardChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetKnockoutForwardChoice> validator(ValidatorFactory factory) {
		return factory.<FxTargetKnockoutForwardChoice>create(FxTargetKnockoutForwardChoiceValidator.class);
	}

	@Override
	public Validator<? super FxTargetKnockoutForwardChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetKnockoutForwardChoice>create(FxTargetKnockoutForwardChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetKnockoutForwardChoice> validator() {
		return new FxTargetKnockoutForwardChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetKnockoutForwardChoice> typeFormatValidator() {
		return new FxTargetKnockoutForwardChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetKnockoutForwardChoice, Set<String>> onlyExistsValidator() {
		return new FxTargetKnockoutForwardChoiceOnlyExistsValidator();
	}
}
