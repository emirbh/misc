package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.EnvironmentCommodityOther2;
import iso20022.auth030.hkma.dtcc.validation.EnvironmentCommodityOther2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.EnvironmentCommodityOther2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.EnvironmentCommodityOther2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnvironmentCommodityOther2.class)
public class EnvironmentCommodityOther2Meta implements RosettaMetaData<EnvironmentCommodityOther2> {

	@Override
	public List<Validator<? super EnvironmentCommodityOther2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentCommodityOther2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentCommodityOther2> validator(ValidatorFactory factory) {
		return factory.<EnvironmentCommodityOther2>create(EnvironmentCommodityOther2Validator.class);
	}

	@Override
	public Validator<? super EnvironmentCommodityOther2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentCommodityOther2>create(EnvironmentCommodityOther2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentCommodityOther2> validator() {
		return new EnvironmentCommodityOther2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentCommodityOther2> typeFormatValidator() {
		return new EnvironmentCommodityOther2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentCommodityOther2, Set<String>> onlyExistsValidator() {
		return new EnvironmentCommodityOther2OnlyExistsValidator();
	}
}
