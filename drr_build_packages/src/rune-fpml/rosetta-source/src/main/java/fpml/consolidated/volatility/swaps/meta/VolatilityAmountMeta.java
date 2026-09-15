package fpml.consolidated.volatility.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.volatility.swaps.VolatilityAmount;
import fpml.consolidated.volatility.swaps.validation.VolatilityAmountTypeFormatValidator;
import fpml.consolidated.volatility.swaps.validation.VolatilityAmountValidator;
import fpml.consolidated.volatility.swaps.validation.exists.VolatilityAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilityAmount.class)
public class VolatilityAmountMeta implements RosettaMetaData<VolatilityAmount> {

	@Override
	public List<Validator<? super VolatilityAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilityAmount> validator(ValidatorFactory factory) {
		return factory.<VolatilityAmount>create(VolatilityAmountValidator.class);
	}

	@Override
	public Validator<? super VolatilityAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilityAmount>create(VolatilityAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityAmount> validator() {
		return new VolatilityAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityAmount> typeFormatValidator() {
		return new VolatilityAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityAmount, Set<String>> onlyExistsValidator() {
		return new VolatilityAmountOnlyExistsValidator();
	}
}
