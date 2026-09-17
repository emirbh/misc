package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherStationWBAN;
import fpml.consolidated.com.validation.WeatherStationWBANTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherStationWBANValidator;
import fpml.consolidated.com.validation.exists.WeatherStationWBANOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherStationWBAN.class)
public class WeatherStationWBANMeta implements RosettaMetaData<WeatherStationWBAN> {

	@Override
	public List<Validator<? super WeatherStationWBAN>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherStationWBAN, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherStationWBAN> validator(ValidatorFactory factory) {
		return factory.<WeatherStationWBAN>create(WeatherStationWBANValidator.class);
	}

	@Override
	public Validator<? super WeatherStationWBAN> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherStationWBAN>create(WeatherStationWBANTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStationWBAN> validator() {
		return new WeatherStationWBANValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStationWBAN> typeFormatValidator() {
		return new WeatherStationWBANTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStationWBAN, Set<String>> onlyExistsValidator() {
		return new WeatherStationWBANOnlyExistsValidator();
	}
}
