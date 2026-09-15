package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.EnvironmentalCommodityWeather2__1;
import iso20022.auth030.fca.validation.EnvironmentalCommodityWeather2__1TypeFormatValidator;
import iso20022.auth030.fca.validation.EnvironmentalCommodityWeather2__1Validator;
import iso20022.auth030.fca.validation.exists.EnvironmentalCommodityWeather2__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnvironmentalCommodityWeather2__1.class)
public class EnvironmentalCommodityWeather2__1Meta implements RosettaMetaData<EnvironmentalCommodityWeather2__1> {

	@Override
	public List<Validator<? super EnvironmentalCommodityWeather2__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalCommodityWeather2__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalCommodityWeather2__1> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityWeather2__1>create(EnvironmentalCommodityWeather2__1Validator.class);
	}

	@Override
	public Validator<? super EnvironmentalCommodityWeather2__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityWeather2__1>create(EnvironmentalCommodityWeather2__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityWeather2__1> validator() {
		return new EnvironmentalCommodityWeather2__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityWeather2__1> typeFormatValidator() {
		return new EnvironmentalCommodityWeather2__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalCommodityWeather2__1, Set<String>> onlyExistsValidator() {
		return new EnvironmentalCommodityWeather2__1OnlyExistsValidator();
	}
}
