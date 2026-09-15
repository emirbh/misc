package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherLeg;
import fpml.consolidated.com.validation.WeatherLegTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherLegValidator;
import fpml.consolidated.com.validation.datarule.WeatherLegChoice;
import fpml.consolidated.com.validation.exists.WeatherLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherLeg.class)
public class WeatherLegMeta implements RosettaMetaData<WeatherLeg> {

	@Override
	public List<Validator<? super WeatherLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<WeatherLeg>create(WeatherLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super WeatherLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherLeg> validator(ValidatorFactory factory) {
		return factory.<WeatherLeg>create(WeatherLegValidator.class);
	}

	@Override
	public Validator<? super WeatherLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherLeg>create(WeatherLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherLeg> validator() {
		return new WeatherLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherLeg> typeFormatValidator() {
		return new WeatherLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherLeg, Set<String>> onlyExistsValidator() {
		return new WeatherLegOnlyExistsValidator();
	}
}
