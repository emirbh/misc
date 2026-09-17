package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.fx.validation.FxVolatilitySwapTypeFormatValidator;
import fpml.consolidated.fx.validation.FxVolatilitySwapValidator;
import fpml.consolidated.fx.validation.datarule.FxPerformanceSwapChoice;
import fpml.consolidated.fx.validation.exists.FxVolatilitySwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxVolatilitySwap.class)
public class FxVolatilitySwapMeta implements RosettaMetaData<FxVolatilitySwap> {

	@Override
	public List<Validator<? super FxVolatilitySwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxPerformanceSwap>create(FxPerformanceSwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxVolatilitySwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxVolatilitySwap> validator(ValidatorFactory factory) {
		return factory.<FxVolatilitySwap>create(FxVolatilitySwapValidator.class);
	}

	@Override
	public Validator<? super FxVolatilitySwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxVolatilitySwap>create(FxVolatilitySwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxVolatilitySwap> validator() {
		return new FxVolatilitySwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxVolatilitySwap> typeFormatValidator() {
		return new FxVolatilitySwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxVolatilitySwap, Set<String>> onlyExistsValidator() {
		return new FxVolatilitySwapOnlyExistsValidator();
	}
}
