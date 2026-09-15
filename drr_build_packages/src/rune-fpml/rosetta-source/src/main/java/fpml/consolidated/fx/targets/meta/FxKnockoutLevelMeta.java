package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxKnockoutLevel;
import fpml.consolidated.fx.targets.validation.FxKnockoutLevelTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxKnockoutLevelValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxKnockoutLevelChoice;
import fpml.consolidated.fx.targets.validation.exists.FxKnockoutLevelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxKnockoutLevel.class)
public class FxKnockoutLevelMeta implements RosettaMetaData<FxKnockoutLevel> {

	@Override
	public List<Validator<? super FxKnockoutLevel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxKnockoutLevel>create(FxKnockoutLevelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxKnockoutLevel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxKnockoutLevel> validator(ValidatorFactory factory) {
		return factory.<FxKnockoutLevel>create(FxKnockoutLevelValidator.class);
	}

	@Override
	public Validator<? super FxKnockoutLevel> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxKnockoutLevel>create(FxKnockoutLevelTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxKnockoutLevel> validator() {
		return new FxKnockoutLevelValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxKnockoutLevel> typeFormatValidator() {
		return new FxKnockoutLevelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxKnockoutLevel, Set<String>> onlyExistsValidator() {
		return new FxKnockoutLevelOnlyExistsValidator();
	}
}
