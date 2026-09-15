package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingParameterDerivative;
import fpml.consolidated.riskdef.validation.PricingParameterDerivativeTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingParameterDerivativeValidator;
import fpml.consolidated.riskdef.validation.datarule.PricingParameterDerivativeChoice;
import fpml.consolidated.riskdef.validation.exists.PricingParameterDerivativeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingParameterDerivative.class)
public class PricingParameterDerivativeMeta implements RosettaMetaData<PricingParameterDerivative> {

	@Override
	public List<Validator<? super PricingParameterDerivative>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PricingParameterDerivative>create(PricingParameterDerivativeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PricingParameterDerivative, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingParameterDerivative> validator(ValidatorFactory factory) {
		return factory.<PricingParameterDerivative>create(PricingParameterDerivativeValidator.class);
	}

	@Override
	public Validator<? super PricingParameterDerivative> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingParameterDerivative>create(PricingParameterDerivativeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingParameterDerivative> validator() {
		return new PricingParameterDerivativeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingParameterDerivative> typeFormatValidator() {
		return new PricingParameterDerivativeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingParameterDerivative, Set<String>> onlyExistsValidator() {
		return new PricingParameterDerivativeOnlyExistsValidator();
	}
}
