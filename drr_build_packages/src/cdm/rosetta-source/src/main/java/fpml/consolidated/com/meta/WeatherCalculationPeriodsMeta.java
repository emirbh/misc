package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherCalculationPeriods;
import fpml.consolidated.com.validation.WeatherCalculationPeriodsTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherCalculationPeriodsValidator;
import fpml.consolidated.com.validation.exists.WeatherCalculationPeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherCalculationPeriods.class)
public class WeatherCalculationPeriodsMeta implements RosettaMetaData<WeatherCalculationPeriods> {

	@Override
	public List<Validator<? super WeatherCalculationPeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherCalculationPeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherCalculationPeriods> validator(ValidatorFactory factory) {
		return factory.<WeatherCalculationPeriods>create(WeatherCalculationPeriodsValidator.class);
	}

	@Override
	public Validator<? super WeatherCalculationPeriods> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherCalculationPeriods>create(WeatherCalculationPeriodsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherCalculationPeriods> validator() {
		return new WeatherCalculationPeriodsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherCalculationPeriods> typeFormatValidator() {
		return new WeatherCalculationPeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherCalculationPeriods, Set<String>> onlyExistsValidator() {
		return new WeatherCalculationPeriodsOnlyExistsValidator();
	}
}
