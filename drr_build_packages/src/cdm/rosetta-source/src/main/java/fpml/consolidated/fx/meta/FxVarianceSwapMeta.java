package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.fx.FxVarianceSwap;
import fpml.consolidated.fx.validation.FxVarianceSwapTypeFormatValidator;
import fpml.consolidated.fx.validation.FxVarianceSwapValidator;
import fpml.consolidated.fx.validation.datarule.FxPerformanceSwapChoice;
import fpml.consolidated.fx.validation.exists.FxVarianceSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxVarianceSwap.class)
public class FxVarianceSwapMeta implements RosettaMetaData<FxVarianceSwap> {

	@Override
	public List<Validator<? super FxVarianceSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxPerformanceSwap>create(FxPerformanceSwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxVarianceSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxVarianceSwap> validator(ValidatorFactory factory) {
		return factory.<FxVarianceSwap>create(FxVarianceSwapValidator.class);
	}

	@Override
	public Validator<? super FxVarianceSwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxVarianceSwap>create(FxVarianceSwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxVarianceSwap> validator() {
		return new FxVarianceSwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxVarianceSwap> typeFormatValidator() {
		return new FxVarianceSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxVarianceSwap, Set<String>> onlyExistsValidator() {
		return new FxVarianceSwapOnlyExistsValidator();
	}
}
