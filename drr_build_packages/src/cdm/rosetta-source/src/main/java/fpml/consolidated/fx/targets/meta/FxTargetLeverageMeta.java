package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetLeverage;
import fpml.consolidated.fx.targets.validation.FxTargetLeverageTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetLeverageValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetLeverageChoice0;
import fpml.consolidated.fx.targets.validation.datarule.FxTargetLeverageChoice1;
import fpml.consolidated.fx.targets.validation.exists.FxTargetLeverageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetLeverage.class)
public class FxTargetLeverageMeta implements RosettaMetaData<FxTargetLeverage> {

	@Override
	public List<Validator<? super FxTargetLeverage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTargetLeverage>create(FxTargetLeverageChoice0.class),
			factory.<FxTargetLeverage>create(FxTargetLeverageChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetLeverage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetLeverage> validator(ValidatorFactory factory) {
		return factory.<FxTargetLeverage>create(FxTargetLeverageValidator.class);
	}

	@Override
	public Validator<? super FxTargetLeverage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetLeverage>create(FxTargetLeverageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetLeverage> validator() {
		return new FxTargetLeverageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetLeverage> typeFormatValidator() {
		return new FxTargetLeverageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetLeverage, Set<String>> onlyExistsValidator() {
		return new FxTargetLeverageOnlyExistsValidator();
	}
}
