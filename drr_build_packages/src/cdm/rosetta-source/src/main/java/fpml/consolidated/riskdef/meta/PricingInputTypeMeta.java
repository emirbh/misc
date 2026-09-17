package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingInputType;
import fpml.consolidated.riskdef.validation.PricingInputTypeTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingInputTypeValidator;
import fpml.consolidated.riskdef.validation.exists.PricingInputTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingInputType.class)
public class PricingInputTypeMeta implements RosettaMetaData<PricingInputType> {

	@Override
	public List<Validator<? super PricingInputType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingInputType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingInputType> validator(ValidatorFactory factory) {
		return factory.<PricingInputType>create(PricingInputTypeValidator.class);
	}

	@Override
	public Validator<? super PricingInputType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingInputType>create(PricingInputTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingInputType> validator() {
		return new PricingInputTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingInputType> typeFormatValidator() {
		return new PricingInputTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingInputType, Set<String>> onlyExistsValidator() {
		return new PricingInputTypeOnlyExistsValidator();
	}
}
