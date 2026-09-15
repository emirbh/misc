package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingParameterDerivativeReference;
import fpml.consolidated.riskdef.validation.PricingParameterDerivativeReferenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingParameterDerivativeReferenceValidator;
import fpml.consolidated.riskdef.validation.exists.PricingParameterDerivativeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingParameterDerivativeReference.class)
public class PricingParameterDerivativeReferenceMeta implements RosettaMetaData<PricingParameterDerivativeReference> {

	@Override
	public List<Validator<? super PricingParameterDerivativeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingParameterDerivativeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingParameterDerivativeReference> validator(ValidatorFactory factory) {
		return factory.<PricingParameterDerivativeReference>create(PricingParameterDerivativeReferenceValidator.class);
	}

	@Override
	public Validator<? super PricingParameterDerivativeReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingParameterDerivativeReference>create(PricingParameterDerivativeReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingParameterDerivativeReference> validator() {
		return new PricingParameterDerivativeReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingParameterDerivativeReference> typeFormatValidator() {
		return new PricingParameterDerivativeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingParameterDerivativeReference, Set<String>> onlyExistsValidator() {
		return new PricingParameterDerivativeReferenceOnlyExistsValidator();
	}
}
