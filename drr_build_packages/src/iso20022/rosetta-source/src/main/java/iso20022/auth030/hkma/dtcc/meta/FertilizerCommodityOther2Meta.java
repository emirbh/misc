package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityOther2;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityOther2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityOther2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.FertilizerCommodityOther2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommodityOther2.class)
public class FertilizerCommodityOther2Meta implements RosettaMetaData<FertilizerCommodityOther2> {

	@Override
	public List<Validator<? super FertilizerCommodityOther2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommodityOther2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommodityOther2> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityOther2>create(FertilizerCommodityOther2Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommodityOther2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityOther2>create(FertilizerCommodityOther2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityOther2> validator() {
		return new FertilizerCommodityOther2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityOther2> typeFormatValidator() {
		return new FertilizerCommodityOther2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommodityOther2, Set<String>> onlyExistsValidator() {
		return new FertilizerCommodityOther2OnlyExistsValidator();
	}
}
