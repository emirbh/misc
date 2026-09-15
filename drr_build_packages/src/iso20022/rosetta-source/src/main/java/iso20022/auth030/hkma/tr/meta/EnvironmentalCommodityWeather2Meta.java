package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.EnvironmentalCommodityWeather2;
import iso20022.auth030.hkma.tr.validation.EnvironmentalCommodityWeather2TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.EnvironmentalCommodityWeather2Validator;
import iso20022.auth030.hkma.tr.validation.exists.EnvironmentalCommodityWeather2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnvironmentalCommodityWeather2.class)
public class EnvironmentalCommodityWeather2Meta implements RosettaMetaData<EnvironmentalCommodityWeather2> {

	@Override
	public List<Validator<? super EnvironmentalCommodityWeather2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalCommodityWeather2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalCommodityWeather2> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityWeather2>create(EnvironmentalCommodityWeather2Validator.class);
	}

	@Override
	public Validator<? super EnvironmentalCommodityWeather2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityWeather2>create(EnvironmentalCommodityWeather2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityWeather2> validator() {
		return new EnvironmentalCommodityWeather2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityWeather2> typeFormatValidator() {
		return new EnvironmentalCommodityWeather2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalCommodityWeather2, Set<String>> onlyExistsValidator() {
		return new EnvironmentalCommodityWeather2OnlyExistsValidator();
	}
}
