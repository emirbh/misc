package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AgriculturalCommoditySoft2;
import iso20022.auth030.esma.validation.AgriculturalCommoditySoft2TypeFormatValidator;
import iso20022.auth030.esma.validation.AgriculturalCommoditySoft2Validator;
import iso20022.auth030.esma.validation.exists.AgriculturalCommoditySoft2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommoditySoft2.class)
public class AgriculturalCommoditySoft2Meta implements RosettaMetaData<AgriculturalCommoditySoft2> {

	@Override
	public List<Validator<? super AgriculturalCommoditySoft2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommoditySoft2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommoditySoft2> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommoditySoft2>create(AgriculturalCommoditySoft2Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommoditySoft2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommoditySoft2>create(AgriculturalCommoditySoft2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommoditySoft2> validator() {
		return new AgriculturalCommoditySoft2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommoditySoft2> typeFormatValidator() {
		return new AgriculturalCommoditySoft2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommoditySoft2, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommoditySoft2OnlyExistsValidator();
	}
}
