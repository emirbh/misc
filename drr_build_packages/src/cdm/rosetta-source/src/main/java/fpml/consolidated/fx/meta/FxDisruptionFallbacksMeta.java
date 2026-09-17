package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDisruptionFallbacks;
import fpml.consolidated.fx.validation.FxDisruptionFallbacksTypeFormatValidator;
import fpml.consolidated.fx.validation.FxDisruptionFallbacksValidator;
import fpml.consolidated.fx.validation.exists.FxDisruptionFallbacksOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDisruptionFallbacks.class)
public class FxDisruptionFallbacksMeta implements RosettaMetaData<FxDisruptionFallbacks> {

	@Override
	public List<Validator<? super FxDisruptionFallbacks>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionFallbacks, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDisruptionFallbacks> validator(ValidatorFactory factory) {
		return factory.<FxDisruptionFallbacks>create(FxDisruptionFallbacksValidator.class);
	}

	@Override
	public Validator<? super FxDisruptionFallbacks> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDisruptionFallbacks>create(FxDisruptionFallbacksTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionFallbacks> validator() {
		return new FxDisruptionFallbacksValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionFallbacks> typeFormatValidator() {
		return new FxDisruptionFallbacksTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionFallbacks, Set<String>> onlyExistsValidator() {
		return new FxDisruptionFallbacksOnlyExistsValidator();
	}
}
