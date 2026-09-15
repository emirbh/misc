package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityOliveOil3;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommodityOliveOil3TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommodityOliveOil3Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.AgriculturalCommodityOliveOil3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommodityOliveOil3.class)
public class AgriculturalCommodityOliveOil3Meta implements RosettaMetaData<AgriculturalCommodityOliveOil3> {

	@Override
	public List<Validator<? super AgriculturalCommodityOliveOil3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommodityOliveOil3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommodityOliveOil3> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityOliveOil3>create(AgriculturalCommodityOliveOil3Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommodityOliveOil3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityOliveOil3>create(AgriculturalCommodityOliveOil3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityOliveOil3> validator() {
		return new AgriculturalCommodityOliveOil3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityOliveOil3> typeFormatValidator() {
		return new AgriculturalCommodityOliveOil3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommodityOliveOil3, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommodityOliveOil3OnlyExistsValidator();
	}
}
