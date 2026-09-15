package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AgriculturalCommodityPotato2;
import iso20022.auth030.esma.validation.AgriculturalCommodityPotato2TypeFormatValidator;
import iso20022.auth030.esma.validation.AgriculturalCommodityPotato2Validator;
import iso20022.auth030.esma.validation.exists.AgriculturalCommodityPotato2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommodityPotato2.class)
public class AgriculturalCommodityPotato2Meta implements RosettaMetaData<AgriculturalCommodityPotato2> {

	@Override
	public List<Validator<? super AgriculturalCommodityPotato2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommodityPotato2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommodityPotato2> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityPotato2>create(AgriculturalCommodityPotato2Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommodityPotato2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityPotato2>create(AgriculturalCommodityPotato2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityPotato2> validator() {
		return new AgriculturalCommodityPotato2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityPotato2> typeFormatValidator() {
		return new AgriculturalCommodityPotato2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommodityPotato2, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommodityPotato2OnlyExistsValidator();
	}
}
