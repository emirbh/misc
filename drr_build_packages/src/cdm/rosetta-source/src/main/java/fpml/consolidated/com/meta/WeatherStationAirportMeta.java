package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherStationAirport;
import fpml.consolidated.com.validation.WeatherStationAirportTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherStationAirportValidator;
import fpml.consolidated.com.validation.exists.WeatherStationAirportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherStationAirport.class)
public class WeatherStationAirportMeta implements RosettaMetaData<WeatherStationAirport> {

	@Override
	public List<Validator<? super WeatherStationAirport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherStationAirport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherStationAirport> validator(ValidatorFactory factory) {
		return factory.<WeatherStationAirport>create(WeatherStationAirportValidator.class);
	}

	@Override
	public Validator<? super WeatherStationAirport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherStationAirport>create(WeatherStationAirportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStationAirport> validator() {
		return new WeatherStationAirportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStationAirport> typeFormatValidator() {
		return new WeatherStationAirportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStationAirport, Set<String>> onlyExistsValidator() {
		return new WeatherStationAirportOnlyExistsValidator();
	}
}
