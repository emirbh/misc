package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFlexibleForwardRate;
import fpml.consolidated.fx.validation.FxFlexibleForwardRateTypeFormatValidator;
import fpml.consolidated.fx.validation.FxFlexibleForwardRateValidator;
import fpml.consolidated.fx.validation.exists.FxFlexibleForwardRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFlexibleForwardRate.class)
public class FxFlexibleForwardRateMeta implements RosettaMetaData<FxFlexibleForwardRate> {

	@Override
	public List<Validator<? super FxFlexibleForwardRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFlexibleForwardRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFlexibleForwardRate> validator(ValidatorFactory factory) {
		return factory.<FxFlexibleForwardRate>create(FxFlexibleForwardRateValidator.class);
	}

	@Override
	public Validator<? super FxFlexibleForwardRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFlexibleForwardRate>create(FxFlexibleForwardRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFlexibleForwardRate> validator() {
		return new FxFlexibleForwardRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFlexibleForwardRate> typeFormatValidator() {
		return new FxFlexibleForwardRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFlexibleForwardRate, Set<String>> onlyExistsValidator() {
		return new FxFlexibleForwardRateOnlyExistsValidator();
	}
}
