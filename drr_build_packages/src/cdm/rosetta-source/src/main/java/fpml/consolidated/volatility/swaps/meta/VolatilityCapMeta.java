package fpml.consolidated.volatility.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.volatility.swaps.VolatilityCap;
import fpml.consolidated.volatility.swaps.validation.VolatilityCapTypeFormatValidator;
import fpml.consolidated.volatility.swaps.validation.VolatilityCapValidator;
import fpml.consolidated.volatility.swaps.validation.exists.VolatilityCapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilityCap.class)
public class VolatilityCapMeta implements RosettaMetaData<VolatilityCap> {

	@Override
	public List<Validator<? super VolatilityCap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityCap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilityCap> validator(ValidatorFactory factory) {
		return factory.<VolatilityCap>create(VolatilityCapValidator.class);
	}

	@Override
	public Validator<? super VolatilityCap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilityCap>create(VolatilityCapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityCap> validator() {
		return new VolatilityCapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityCap> typeFormatValidator() {
		return new VolatilityCapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityCap, Set<String>> onlyExistsValidator() {
		return new VolatilityCapOnlyExistsValidator();
	}
}
