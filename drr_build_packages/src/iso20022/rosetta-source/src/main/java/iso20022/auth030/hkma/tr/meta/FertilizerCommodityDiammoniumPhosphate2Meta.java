package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.FertilizerCommodityDiammoniumPhosphate2;
import iso20022.auth030.hkma.tr.validation.FertilizerCommodityDiammoniumPhosphate2TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.FertilizerCommodityDiammoniumPhosphate2Validator;
import iso20022.auth030.hkma.tr.validation.exists.FertilizerCommodityDiammoniumPhosphate2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommodityDiammoniumPhosphate2.class)
public class FertilizerCommodityDiammoniumPhosphate2Meta implements RosettaMetaData<FertilizerCommodityDiammoniumPhosphate2> {

	@Override
	public List<Validator<? super FertilizerCommodityDiammoniumPhosphate2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommodityDiammoniumPhosphate2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommodityDiammoniumPhosphate2> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityDiammoniumPhosphate2>create(FertilizerCommodityDiammoniumPhosphate2Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommodityDiammoniumPhosphate2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityDiammoniumPhosphate2>create(FertilizerCommodityDiammoniumPhosphate2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityDiammoniumPhosphate2> validator() {
		return new FertilizerCommodityDiammoniumPhosphate2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityDiammoniumPhosphate2> typeFormatValidator() {
		return new FertilizerCommodityDiammoniumPhosphate2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommodityDiammoniumPhosphate2, Set<String>> onlyExistsValidator() {
		return new FertilizerCommodityDiammoniumPhosphate2OnlyExistsValidator();
	}
}
