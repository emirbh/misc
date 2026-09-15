package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTarget;
import fpml.consolidated.fx.targets.validation.FxTargetTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTarget.class)
public class FxTargetMeta implements RosettaMetaData<FxTarget> {

	@Override
	public List<Validator<? super FxTarget>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTarget>create(FxTargetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTarget, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTarget> validator(ValidatorFactory factory) {
		return factory.<FxTarget>create(FxTargetValidator.class);
	}

	@Override
	public Validator<? super FxTarget> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTarget>create(FxTargetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTarget> validator() {
		return new FxTargetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTarget> typeFormatValidator() {
		return new FxTargetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTarget, Set<String>> onlyExistsValidator() {
		return new FxTargetOnlyExistsValidator();
	}
}
