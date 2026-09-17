package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDisruptionFallback;
import fpml.consolidated.fx.validation.FxDisruptionFallbackTypeFormatValidator;
import fpml.consolidated.fx.validation.FxDisruptionFallbackValidator;
import fpml.consolidated.fx.validation.exists.FxDisruptionFallbackOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDisruptionFallback.class)
public class FxDisruptionFallbackMeta implements RosettaMetaData<FxDisruptionFallback> {

	@Override
	public List<Validator<? super FxDisruptionFallback>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionFallback, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDisruptionFallback> validator(ValidatorFactory factory) {
		return factory.<FxDisruptionFallback>create(FxDisruptionFallbackValidator.class);
	}

	@Override
	public Validator<? super FxDisruptionFallback> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDisruptionFallback>create(FxDisruptionFallbackTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionFallback> validator() {
		return new FxDisruptionFallbackValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionFallback> typeFormatValidator() {
		return new FxDisruptionFallbackTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionFallback, Set<String>> onlyExistsValidator() {
		return new FxDisruptionFallbackOnlyExistsValidator();
	}
}
