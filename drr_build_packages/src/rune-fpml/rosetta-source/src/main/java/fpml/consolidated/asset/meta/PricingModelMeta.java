package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.PricingModel;
import fpml.consolidated.asset.validation.PricingModelTypeFormatValidator;
import fpml.consolidated.asset.validation.PricingModelValidator;
import fpml.consolidated.asset.validation.exists.PricingModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingModel.class)
public class PricingModelMeta implements RosettaMetaData<PricingModel> {

	@Override
	public List<Validator<? super PricingModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingModel> validator(ValidatorFactory factory) {
		return factory.<PricingModel>create(PricingModelValidator.class);
	}

	@Override
	public Validator<? super PricingModel> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingModel>create(PricingModelTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingModel> validator() {
		return new PricingModelValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingModel> typeFormatValidator() {
		return new PricingModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingModel, Set<String>> onlyExistsValidator() {
		return new PricingModelOnlyExistsValidator();
	}
}
