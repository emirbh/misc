package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityUrea2;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityUrea2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityUrea2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.FertilizerCommodityUrea2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommodityUrea2.class)
public class FertilizerCommodityUrea2Meta implements RosettaMetaData<FertilizerCommodityUrea2> {

	@Override
	public List<Validator<? super FertilizerCommodityUrea2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommodityUrea2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommodityUrea2> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityUrea2>create(FertilizerCommodityUrea2Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommodityUrea2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityUrea2>create(FertilizerCommodityUrea2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityUrea2> validator() {
		return new FertilizerCommodityUrea2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityUrea2> typeFormatValidator() {
		return new FertilizerCommodityUrea2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommodityUrea2, Set<String>> onlyExistsValidator() {
		return new FertilizerCommodityUrea2OnlyExistsValidator();
	}
}
