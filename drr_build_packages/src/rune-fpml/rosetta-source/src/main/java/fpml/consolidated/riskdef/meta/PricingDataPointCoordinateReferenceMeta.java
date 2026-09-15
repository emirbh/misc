package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingDataPointCoordinateReference;
import fpml.consolidated.riskdef.validation.PricingDataPointCoordinateReferenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingDataPointCoordinateReferenceValidator;
import fpml.consolidated.riskdef.validation.exists.PricingDataPointCoordinateReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingDataPointCoordinateReference.class)
public class PricingDataPointCoordinateReferenceMeta implements RosettaMetaData<PricingDataPointCoordinateReference> {

	@Override
	public List<Validator<? super PricingDataPointCoordinateReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingDataPointCoordinateReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingDataPointCoordinateReference> validator(ValidatorFactory factory) {
		return factory.<PricingDataPointCoordinateReference>create(PricingDataPointCoordinateReferenceValidator.class);
	}

	@Override
	public Validator<? super PricingDataPointCoordinateReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingDataPointCoordinateReference>create(PricingDataPointCoordinateReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingDataPointCoordinateReference> validator() {
		return new PricingDataPointCoordinateReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingDataPointCoordinateReference> typeFormatValidator() {
		return new PricingDataPointCoordinateReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingDataPointCoordinateReference, Set<String>> onlyExistsValidator() {
		return new PricingDataPointCoordinateReferenceOnlyExistsValidator();
	}
}
