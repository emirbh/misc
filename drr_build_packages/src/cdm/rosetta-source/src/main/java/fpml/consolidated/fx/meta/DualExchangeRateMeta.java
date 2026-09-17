package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.DualExchangeRate;
import fpml.consolidated.fx.validation.DualExchangeRateTypeFormatValidator;
import fpml.consolidated.fx.validation.DualExchangeRateValidator;
import fpml.consolidated.fx.validation.exists.DualExchangeRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DualExchangeRate.class)
public class DualExchangeRateMeta implements RosettaMetaData<DualExchangeRate> {

	@Override
	public List<Validator<? super DualExchangeRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DualExchangeRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DualExchangeRate> validator(ValidatorFactory factory) {
		return factory.<DualExchangeRate>create(DualExchangeRateValidator.class);
	}

	@Override
	public Validator<? super DualExchangeRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DualExchangeRate>create(DualExchangeRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DualExchangeRate> validator() {
		return new DualExchangeRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DualExchangeRate> typeFormatValidator() {
		return new DualExchangeRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DualExchangeRate, Set<String>> onlyExistsValidator() {
		return new DualExchangeRateOnlyExistsValidator();
	}
}
