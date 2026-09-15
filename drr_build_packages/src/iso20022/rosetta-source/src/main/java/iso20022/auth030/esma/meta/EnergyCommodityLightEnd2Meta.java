package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.EnergyCommodityLightEnd2;
import iso20022.auth030.esma.validation.EnergyCommodityLightEnd2TypeFormatValidator;
import iso20022.auth030.esma.validation.EnergyCommodityLightEnd2Validator;
import iso20022.auth030.esma.validation.exists.EnergyCommodityLightEnd2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityLightEnd2.class)
public class EnergyCommodityLightEnd2Meta implements RosettaMetaData<EnergyCommodityLightEnd2> {

	@Override
	public List<Validator<? super EnergyCommodityLightEnd2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityLightEnd2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityLightEnd2> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityLightEnd2>create(EnergyCommodityLightEnd2Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityLightEnd2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityLightEnd2>create(EnergyCommodityLightEnd2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityLightEnd2> validator() {
		return new EnergyCommodityLightEnd2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityLightEnd2> typeFormatValidator() {
		return new EnergyCommodityLightEnd2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityLightEnd2, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityLightEnd2OnlyExistsValidator();
	}
}
