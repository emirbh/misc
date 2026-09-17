package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherStationWMO;
import fpml.consolidated.com.validation.WeatherStationWMOTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherStationWMOValidator;
import fpml.consolidated.com.validation.exists.WeatherStationWMOOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherStationWMO.class)
public class WeatherStationWMOMeta implements RosettaMetaData<WeatherStationWMO> {

	@Override
	public List<Validator<? super WeatherStationWMO>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherStationWMO, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherStationWMO> validator(ValidatorFactory factory) {
		return factory.<WeatherStationWMO>create(WeatherStationWMOValidator.class);
	}

	@Override
	public Validator<? super WeatherStationWMO> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherStationWMO>create(WeatherStationWMOTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStationWMO> validator() {
		return new WeatherStationWMOValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherStationWMO> typeFormatValidator() {
		return new WeatherStationWMOTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherStationWMO, Set<String>> onlyExistsValidator() {
		return new WeatherStationWMOOnlyExistsValidator();
	}
}
