package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityPotash2;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityPotash2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityPotash2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.FertilizerCommodityPotash2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommodityPotash2.class)
public class FertilizerCommodityPotash2Meta implements RosettaMetaData<FertilizerCommodityPotash2> {

	@Override
	public List<Validator<? super FertilizerCommodityPotash2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommodityPotash2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommodityPotash2> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityPotash2>create(FertilizerCommodityPotash2Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommodityPotash2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityPotash2>create(FertilizerCommodityPotash2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityPotash2> validator() {
		return new FertilizerCommodityPotash2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityPotash2> typeFormatValidator() {
		return new FertilizerCommodityPotash2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommodityPotash2, Set<String>> onlyExistsValidator() {
		return new FertilizerCommodityPotash2OnlyExistsValidator();
	}
}
