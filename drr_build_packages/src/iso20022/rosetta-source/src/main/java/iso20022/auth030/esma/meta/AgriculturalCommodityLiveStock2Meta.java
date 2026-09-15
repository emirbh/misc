package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AgriculturalCommodityLiveStock2;
import iso20022.auth030.esma.validation.AgriculturalCommodityLiveStock2TypeFormatValidator;
import iso20022.auth030.esma.validation.AgriculturalCommodityLiveStock2Validator;
import iso20022.auth030.esma.validation.exists.AgriculturalCommodityLiveStock2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommodityLiveStock2.class)
public class AgriculturalCommodityLiveStock2Meta implements RosettaMetaData<AgriculturalCommodityLiveStock2> {

	@Override
	public List<Validator<? super AgriculturalCommodityLiveStock2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommodityLiveStock2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommodityLiveStock2> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityLiveStock2>create(AgriculturalCommodityLiveStock2Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommodityLiveStock2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityLiveStock2>create(AgriculturalCommodityLiveStock2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityLiveStock2> validator() {
		return new AgriculturalCommodityLiveStock2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityLiveStock2> typeFormatValidator() {
		return new AgriculturalCommodityLiveStock2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommodityLiveStock2, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommodityLiveStock2OnlyExistsValidator();
	}
}
