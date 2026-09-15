package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityOther2;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommodityOther2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommodityOther2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.AgriculturalCommodityOther2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommodityOther2.class)
public class AgriculturalCommodityOther2Meta implements RosettaMetaData<AgriculturalCommodityOther2> {

	@Override
	public List<Validator<? super AgriculturalCommodityOther2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommodityOther2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommodityOther2> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityOther2>create(AgriculturalCommodityOther2Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommodityOther2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityOther2>create(AgriculturalCommodityOther2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityOther2> validator() {
		return new AgriculturalCommodityOther2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityOther2> typeFormatValidator() {
		return new AgriculturalCommodityOther2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommodityOther2, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommodityOther2OnlyExistsValidator();
	}
}
