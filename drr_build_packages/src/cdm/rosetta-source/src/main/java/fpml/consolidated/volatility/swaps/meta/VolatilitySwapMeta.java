package fpml.consolidated.volatility.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import fpml.consolidated.volatility.swaps.validation.VolatilitySwapTypeFormatValidator;
import fpml.consolidated.volatility.swaps.validation.VolatilitySwapValidator;
import fpml.consolidated.volatility.swaps.validation.exists.VolatilitySwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilitySwap.class)
public class VolatilitySwapMeta implements RosettaMetaData<VolatilitySwap> {

	@Override
	public List<Validator<? super VolatilitySwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilitySwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilitySwap> validator(ValidatorFactory factory) {
		return factory.<VolatilitySwap>create(VolatilitySwapValidator.class);
	}

	@Override
	public Validator<? super VolatilitySwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilitySwap>create(VolatilitySwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilitySwap> validator() {
		return new VolatilitySwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilitySwap> typeFormatValidator() {
		return new VolatilitySwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilitySwap, Set<String>> onlyExistsValidator() {
		return new VolatilitySwapOnlyExistsValidator();
	}
}
