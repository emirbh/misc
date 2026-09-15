package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityForestry2;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommodityForestry2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommodityForestry2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.AgriculturalCommodityForestry2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommodityForestry2.class)
public class AgriculturalCommodityForestry2Meta implements RosettaMetaData<AgriculturalCommodityForestry2> {

	@Override
	public List<Validator<? super AgriculturalCommodityForestry2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommodityForestry2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommodityForestry2> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityForestry2>create(AgriculturalCommodityForestry2Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommodityForestry2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityForestry2>create(AgriculturalCommodityForestry2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityForestry2> validator() {
		return new AgriculturalCommodityForestry2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityForestry2> typeFormatValidator() {
		return new AgriculturalCommodityForestry2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommodityForestry2, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommodityForestry2OnlyExistsValidator();
	}
}
