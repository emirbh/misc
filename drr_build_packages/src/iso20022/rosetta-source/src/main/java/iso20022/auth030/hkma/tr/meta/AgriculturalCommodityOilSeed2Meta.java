package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOilSeed2;
import iso20022.auth030.hkma.tr.validation.AgriculturalCommodityOilSeed2TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.AgriculturalCommodityOilSeed2Validator;
import iso20022.auth030.hkma.tr.validation.exists.AgriculturalCommodityOilSeed2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommodityOilSeed2.class)
public class AgriculturalCommodityOilSeed2Meta implements RosettaMetaData<AgriculturalCommodityOilSeed2> {

	@Override
	public List<Validator<? super AgriculturalCommodityOilSeed2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommodityOilSeed2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommodityOilSeed2> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityOilSeed2>create(AgriculturalCommodityOilSeed2Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommodityOilSeed2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityOilSeed2>create(AgriculturalCommodityOilSeed2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityOilSeed2> validator() {
		return new AgriculturalCommodityOilSeed2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityOilSeed2> typeFormatValidator() {
		return new AgriculturalCommodityOilSeed2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommodityOilSeed2, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommodityOilSeed2OnlyExistsValidator();
	}
}
