package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AgriculturalCommoditySoft2__1;
import iso20022.auth030.fca.validation.AgriculturalCommoditySoft2__1TypeFormatValidator;
import iso20022.auth030.fca.validation.AgriculturalCommoditySoft2__1Validator;
import iso20022.auth030.fca.validation.exists.AgriculturalCommoditySoft2__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommoditySoft2__1.class)
public class AgriculturalCommoditySoft2__1Meta implements RosettaMetaData<AgriculturalCommoditySoft2__1> {

	@Override
	public List<Validator<? super AgriculturalCommoditySoft2__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommoditySoft2__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommoditySoft2__1> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommoditySoft2__1>create(AgriculturalCommoditySoft2__1Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommoditySoft2__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommoditySoft2__1>create(AgriculturalCommoditySoft2__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommoditySoft2__1> validator() {
		return new AgriculturalCommoditySoft2__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommoditySoft2__1> typeFormatValidator() {
		return new AgriculturalCommoditySoft2__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommoditySoft2__1, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommoditySoft2__1OnlyExistsValidator();
	}
}
