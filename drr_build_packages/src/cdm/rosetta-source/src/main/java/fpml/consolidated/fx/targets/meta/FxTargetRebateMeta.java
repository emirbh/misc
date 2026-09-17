package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetRebate;
import fpml.consolidated.fx.targets.validation.FxTargetRebateTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetRebateValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetRebateChoice;
import fpml.consolidated.fx.targets.validation.exists.FxTargetRebateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetRebate.class)
public class FxTargetRebateMeta implements RosettaMetaData<FxTargetRebate> {

	@Override
	public List<Validator<? super FxTargetRebate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetRebate>create(FxTargetRebateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetRebate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetRebate> validator(ValidatorFactory factory) {
		return factory.<FxTargetRebate>create(FxTargetRebateValidator.class);
	}

	@Override
	public Validator<? super FxTargetRebate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetRebate>create(FxTargetRebateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetRebate> validator() {
		return new FxTargetRebateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetRebate> typeFormatValidator() {
		return new FxTargetRebateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRebate, Set<String>> onlyExistsValidator() {
		return new FxTargetRebateOnlyExistsValidator();
	}
}
