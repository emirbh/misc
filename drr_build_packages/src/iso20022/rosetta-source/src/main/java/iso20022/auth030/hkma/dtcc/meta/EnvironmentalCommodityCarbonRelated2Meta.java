package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.EnvironmentalCommodityCarbonRelated2;
import iso20022.auth030.hkma.dtcc.validation.EnvironmentalCommodityCarbonRelated2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.EnvironmentalCommodityCarbonRelated2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.EnvironmentalCommodityCarbonRelated2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnvironmentalCommodityCarbonRelated2.class)
public class EnvironmentalCommodityCarbonRelated2Meta implements RosettaMetaData<EnvironmentalCommodityCarbonRelated2> {

	@Override
	public List<Validator<? super EnvironmentalCommodityCarbonRelated2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalCommodityCarbonRelated2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalCommodityCarbonRelated2> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityCarbonRelated2>create(EnvironmentalCommodityCarbonRelated2Validator.class);
	}

	@Override
	public Validator<? super EnvironmentalCommodityCarbonRelated2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityCarbonRelated2>create(EnvironmentalCommodityCarbonRelated2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityCarbonRelated2> validator() {
		return new EnvironmentalCommodityCarbonRelated2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityCarbonRelated2> typeFormatValidator() {
		return new EnvironmentalCommodityCarbonRelated2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalCommodityCarbonRelated2, Set<String>> onlyExistsValidator() {
		return new EnvironmentalCommodityCarbonRelated2OnlyExistsValidator();
	}
}
