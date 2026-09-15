package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherIndexData;
import fpml.consolidated.com.validation.WeatherIndexDataTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherIndexDataValidator;
import fpml.consolidated.com.validation.exists.WeatherIndexDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherIndexData.class)
public class WeatherIndexDataMeta implements RosettaMetaData<WeatherIndexData> {

	@Override
	public List<Validator<? super WeatherIndexData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherIndexData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherIndexData> validator(ValidatorFactory factory) {
		return factory.<WeatherIndexData>create(WeatherIndexDataValidator.class);
	}

	@Override
	public Validator<? super WeatherIndexData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherIndexData>create(WeatherIndexDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherIndexData> validator() {
		return new WeatherIndexDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherIndexData> typeFormatValidator() {
		return new WeatherIndexDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherIndexData, Set<String>> onlyExistsValidator() {
		return new WeatherIndexDataOnlyExistsValidator();
	}
}
