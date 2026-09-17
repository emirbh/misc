package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.fx.validation.FxPerformanceSwapTypeFormatValidator;
import fpml.consolidated.fx.validation.FxPerformanceSwapValidator;
import fpml.consolidated.fx.validation.datarule.FxPerformanceSwapChoice;
import fpml.consolidated.fx.validation.exists.FxPerformanceSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxPerformanceSwap.class)
public class FxPerformanceSwapMeta implements RosettaMetaData<FxPerformanceSwap> {

	@Override
	public List<Validator<? super FxPerformanceSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxPerformanceSwap>create(FxPerformanceSwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxPerformanceSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxPerformanceSwap> validator(ValidatorFactory factory) {
		return factory.<FxPerformanceSwap>create(FxPerformanceSwapValidator.class);
	}

	@Override
	public Validator<? super FxPerformanceSwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxPerformanceSwap>create(FxPerformanceSwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxPerformanceSwap> validator() {
		return new FxPerformanceSwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxPerformanceSwap> typeFormatValidator() {
		return new FxPerformanceSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPerformanceSwap, Set<String>> onlyExistsValidator() {
		return new FxPerformanceSwapOnlyExistsValidator();
	}
}
