package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AgriculturalCommodityGrain3;
import iso20022.auth030.esma.validation.AgriculturalCommodityGrain3TypeFormatValidator;
import iso20022.auth030.esma.validation.AgriculturalCommodityGrain3Validator;
import iso20022.auth030.esma.validation.exists.AgriculturalCommodityGrain3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommodityGrain3.class)
public class AgriculturalCommodityGrain3Meta implements RosettaMetaData<AgriculturalCommodityGrain3> {

	@Override
	public List<Validator<? super AgriculturalCommodityGrain3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommodityGrain3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommodityGrain3> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityGrain3>create(AgriculturalCommodityGrain3Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommodityGrain3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommodityGrain3>create(AgriculturalCommodityGrain3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityGrain3> validator() {
		return new AgriculturalCommodityGrain3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommodityGrain3> typeFormatValidator() {
		return new AgriculturalCommodityGrain3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommodityGrain3, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommodityGrain3OnlyExistsValidator();
	}
}
