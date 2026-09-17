package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxLevel;
import fpml.consolidated.fx.targets.validation.FxLevelTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxLevelValidator;
import fpml.consolidated.fx.targets.validation.exists.FxLevelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxLevel.class)
public class FxLevelMeta implements RosettaMetaData<FxLevel> {

	@Override
	public List<Validator<? super FxLevel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxLevel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxLevel> validator(ValidatorFactory factory) {
		return factory.<FxLevel>create(FxLevelValidator.class);
	}

	@Override
	public Validator<? super FxLevel> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxLevel>create(FxLevelTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxLevel> validator() {
		return new FxLevelValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxLevel> typeFormatValidator() {
		return new FxLevelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxLevel, Set<String>> onlyExistsValidator() {
		return new FxLevelOnlyExistsValidator();
	}
}
