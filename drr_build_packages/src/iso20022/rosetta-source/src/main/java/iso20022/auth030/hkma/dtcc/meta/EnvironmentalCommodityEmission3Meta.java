package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.EnvironmentalCommodityEmission3;
import iso20022.auth030.hkma.dtcc.validation.EnvironmentalCommodityEmission3TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.EnvironmentalCommodityEmission3Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.EnvironmentalCommodityEmission3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnvironmentalCommodityEmission3.class)
public class EnvironmentalCommodityEmission3Meta implements RosettaMetaData<EnvironmentalCommodityEmission3> {

	@Override
	public List<Validator<? super EnvironmentalCommodityEmission3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalCommodityEmission3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalCommodityEmission3> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityEmission3>create(EnvironmentalCommodityEmission3Validator.class);
	}

	@Override
	public Validator<? super EnvironmentalCommodityEmission3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalCommodityEmission3>create(EnvironmentalCommodityEmission3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityEmission3> validator() {
		return new EnvironmentalCommodityEmission3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalCommodityEmission3> typeFormatValidator() {
		return new EnvironmentalCommodityEmission3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalCommodityEmission3, Set<String>> onlyExistsValidator() {
		return new EnvironmentalCommodityEmission3OnlyExistsValidator();
	}
}
