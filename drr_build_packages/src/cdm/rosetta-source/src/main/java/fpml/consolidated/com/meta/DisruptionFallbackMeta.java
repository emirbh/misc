package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.DisruptionFallback;
import fpml.consolidated.com.validation.DisruptionFallbackTypeFormatValidator;
import fpml.consolidated.com.validation.DisruptionFallbackValidator;
import fpml.consolidated.com.validation.exists.DisruptionFallbackOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DisruptionFallback.class)
public class DisruptionFallbackMeta implements RosettaMetaData<DisruptionFallback> {

	@Override
	public List<Validator<? super DisruptionFallback>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DisruptionFallback, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DisruptionFallback> validator(ValidatorFactory factory) {
		return factory.<DisruptionFallback>create(DisruptionFallbackValidator.class);
	}

	@Override
	public Validator<? super DisruptionFallback> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DisruptionFallback>create(DisruptionFallbackTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DisruptionFallback> validator() {
		return new DisruptionFallbackValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DisruptionFallback> typeFormatValidator() {
		return new DisruptionFallbackTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DisruptionFallback, Set<String>> onlyExistsValidator() {
		return new DisruptionFallbackOnlyExistsValidator();
	}
}
