package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityAmmonia2;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityAmmonia2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityAmmonia2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.FertilizerCommodityAmmonia2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommodityAmmonia2.class)
public class FertilizerCommodityAmmonia2Meta implements RosettaMetaData<FertilizerCommodityAmmonia2> {

	@Override
	public List<Validator<? super FertilizerCommodityAmmonia2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommodityAmmonia2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommodityAmmonia2> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityAmmonia2>create(FertilizerCommodityAmmonia2Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommodityAmmonia2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityAmmonia2>create(FertilizerCommodityAmmonia2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityAmmonia2> validator() {
		return new FertilizerCommodityAmmonia2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityAmmonia2> typeFormatValidator() {
		return new FertilizerCommodityAmmonia2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommodityAmmonia2, Set<String>> onlyExistsValidator() {
		return new FertilizerCommodityAmmonia2OnlyExistsValidator();
	}
}
