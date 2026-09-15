package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AgriculturalCommoditySeafood2;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommoditySeafood2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AgriculturalCommoditySeafood2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.AgriculturalCommoditySeafood2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgriculturalCommoditySeafood2.class)
public class AgriculturalCommoditySeafood2Meta implements RosettaMetaData<AgriculturalCommoditySeafood2> {

	@Override
	public List<Validator<? super AgriculturalCommoditySeafood2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgriculturalCommoditySeafood2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgriculturalCommoditySeafood2> validator(ValidatorFactory factory) {
		return factory.<AgriculturalCommoditySeafood2>create(AgriculturalCommoditySeafood2Validator.class);
	}

	@Override
	public Validator<? super AgriculturalCommoditySeafood2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AgriculturalCommoditySeafood2>create(AgriculturalCommoditySeafood2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommoditySeafood2> validator() {
		return new AgriculturalCommoditySeafood2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super AgriculturalCommoditySeafood2> typeFormatValidator() {
		return new AgriculturalCommoditySeafood2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgriculturalCommoditySeafood2, Set<String>> onlyExistsValidator() {
		return new AgriculturalCommoditySeafood2OnlyExistsValidator();
	}
}
