package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherStation;
import fpml.consolidated.com.validation.WeatherStationTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherStationValidator;
import fpml.consolidated.com.validation.datarule.WeatherStationChoice;
import fpml.consolidated.com.validation.exists.WeatherStationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherStation.class)
public class WeatherStationMeta implements RosettaMetaData<WeatherStation> {

	@Override
	public List<Validator<? super WeatherStation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<WeatherStation>create(WeatherStationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super WeatherStation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherStation> validator(ValidatorFactory factory) {
		return factory.<WeatherStation>create(WeatherStationValidator.class);
	}

	@Override
	public Validator<? super WeatherStation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherStation>create(WeatherStationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStation> validator() {
		return new WeatherStationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStation> typeFormatValidator() {
		return new WeatherStationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStation, Set<String>> onlyExistsValidator() {
		return new WeatherStationOnlyExistsValidator();
	}
}
