package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.FloatingRateCalculationReference;
import fpml.consolidated.eq.shared.validation.FloatingRateCalculationReferenceTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.FloatingRateCalculationReferenceValidator;
import fpml.consolidated.eq.shared.validation.exists.FloatingRateCalculationReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingRateCalculationReference.class)
public class FloatingRateCalculationReferenceMeta implements RosettaMetaData<FloatingRateCalculationReference> {

	@Override
	public List<Validator<? super FloatingRateCalculationReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateCalculationReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateCalculationReference> validator(ValidatorFactory factory) {
		return factory.<FloatingRateCalculationReference>create(FloatingRateCalculationReferenceValidator.class);
	}

	@Override
	public Validator<? super FloatingRateCalculationReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateCalculationReference>create(FloatingRateCalculationReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateCalculationReference> validator() {
		return new FloatingRateCalculationReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateCalculationReference> typeFormatValidator() {
		return new FloatingRateCalculationReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateCalculationReference, Set<String>> onlyExistsValidator() {
		return new FloatingRateCalculationReferenceOnlyExistsValidator();
	}
}
