package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.validation.FallbackRateTypeFormatValidator;
import fpml.consolidated.shared.validation.FallbackRateValidator;
import fpml.consolidated.shared.validation.datarule.FallbackRateChoice;
import fpml.consolidated.shared.validation.exists.FallbackRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FallbackRate.class)
public class FallbackRateMeta implements RosettaMetaData<FallbackRate> {

	@Override
	public List<Validator<? super FallbackRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FallbackRate>create(FallbackRateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FallbackRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FallbackRate> validator(ValidatorFactory factory) {
		return factory.<FallbackRate>create(FallbackRateValidator.class);
	}

	@Override
	public Validator<? super FallbackRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FallbackRate>create(FallbackRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FallbackRate> validator() {
		return new FallbackRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FallbackRate> typeFormatValidator() {
		return new FallbackRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FallbackRate, Set<String>> onlyExistsValidator() {
		return new FallbackRateOnlyExistsValidator();
	}
}
