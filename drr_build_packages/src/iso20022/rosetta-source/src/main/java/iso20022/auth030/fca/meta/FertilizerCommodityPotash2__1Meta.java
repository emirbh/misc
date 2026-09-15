package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.FertilizerCommodityPotash2__1;
import iso20022.auth030.fca.validation.FertilizerCommodityPotash2__1TypeFormatValidator;
import iso20022.auth030.fca.validation.FertilizerCommodityPotash2__1Validator;
import iso20022.auth030.fca.validation.exists.FertilizerCommodityPotash2__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommodityPotash2__1.class)
public class FertilizerCommodityPotash2__1Meta implements RosettaMetaData<FertilizerCommodityPotash2__1> {

	@Override
	public List<Validator<? super FertilizerCommodityPotash2__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommodityPotash2__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommodityPotash2__1> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityPotash2__1>create(FertilizerCommodityPotash2__1Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommodityPotash2__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityPotash2__1>create(FertilizerCommodityPotash2__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityPotash2__1> validator() {
		return new FertilizerCommodityPotash2__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityPotash2__1> typeFormatValidator() {
		return new FertilizerCommodityPotash2__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommodityPotash2__1, Set<String>> onlyExistsValidator() {
		return new FertilizerCommodityPotash2__1OnlyExistsValidator();
	}
}
