package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherIndex;
import fpml.consolidated.com.validation.WeatherIndexTypeFormatValidator;
import fpml.consolidated.com.validation.WeatherIndexValidator;
import fpml.consolidated.com.validation.exists.WeatherIndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WeatherIndex.class)
public class WeatherIndexMeta implements RosettaMetaData<WeatherIndex> {

	@Override
	public List<Validator<? super WeatherIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeatherIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeatherIndex> validator(ValidatorFactory factory) {
		return factory.<WeatherIndex>create(WeatherIndexValidator.class);
	}

	@Override
	public Validator<? super WeatherIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WeatherIndex>create(WeatherIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WeatherIndex> validator() {
		return new WeatherIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WeatherIndex> typeFormatValidator() {
		return new WeatherIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeatherIndex, Set<String>> onlyExistsValidator() {
		return new WeatherIndexOnlyExistsValidator();
	}
}
