package fpml.consolidated.volatility.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyer;
import fpml.consolidated.eq.shared.validation.datarule.DirectionalLegUnderlyerChoice;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.validation.VolatilityLegTypeFormatValidator;
import fpml.consolidated.volatility.swaps.validation.VolatilityLegValidator;
import fpml.consolidated.volatility.swaps.validation.exists.VolatilityLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilityLeg.class)
public class VolatilityLegMeta implements RosettaMetaData<VolatilityLeg> {

	@Override
	public List<Validator<? super VolatilityLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VolatilityLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilityLeg> validator(ValidatorFactory factory) {
		return factory.<VolatilityLeg>create(VolatilityLegValidator.class);
	}

	@Override
	public Validator<? super VolatilityLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilityLeg>create(VolatilityLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityLeg> validator() {
		return new VolatilityLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityLeg> typeFormatValidator() {
		return new VolatilityLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityLeg, Set<String>> onlyExistsValidator() {
		return new VolatilityLegOnlyExistsValidator();
	}
}
