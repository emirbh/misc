package fpml.consolidated.volatility.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.CalculationFromObservation;
import fpml.consolidated.eq.shared.validation.datarule.CalculationFromObservationChoice;
import fpml.consolidated.volatility.swaps.Volatility;
import fpml.consolidated.volatility.swaps.validation.VolatilityTypeFormatValidator;
import fpml.consolidated.volatility.swaps.validation.VolatilityValidator;
import fpml.consolidated.volatility.swaps.validation.exists.VolatilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Volatility.class)
public class VolatilityMeta implements RosettaMetaData<Volatility> {

	@Override
	public List<Validator<? super Volatility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationFromObservation>create(CalculationFromObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Volatility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Volatility> validator(ValidatorFactory factory) {
		return factory.<Volatility>create(VolatilityValidator.class);
	}

	@Override
	public Validator<? super Volatility> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Volatility>create(VolatilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Volatility> validator() {
		return new VolatilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Volatility> typeFormatValidator() {
		return new VolatilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Volatility, Set<String>> onlyExistsValidator() {
		return new VolatilityOnlyExistsValidator();
	}
}
