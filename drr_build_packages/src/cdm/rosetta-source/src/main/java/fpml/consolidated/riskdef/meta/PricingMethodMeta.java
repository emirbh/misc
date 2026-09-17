package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingMethod;
import fpml.consolidated.riskdef.validation.PricingMethodTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingMethodValidator;
import fpml.consolidated.riskdef.validation.exists.PricingMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingMethod.class)
public class PricingMethodMeta implements RosettaMetaData<PricingMethod> {

	@Override
	public List<Validator<? super PricingMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingMethod> validator(ValidatorFactory factory) {
		return factory.<PricingMethod>create(PricingMethodValidator.class);
	}

	@Override
	public Validator<? super PricingMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingMethod>create(PricingMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingMethod> validator() {
		return new PricingMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingMethod> typeFormatValidator() {
		return new PricingMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingMethod, Set<String>> onlyExistsValidator() {
		return new PricingMethodOnlyExistsValidator();
	}
}
