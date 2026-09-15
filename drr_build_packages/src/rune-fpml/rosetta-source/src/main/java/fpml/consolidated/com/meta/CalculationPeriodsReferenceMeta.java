package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.validation.CalculationPeriodsReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.CalculationPeriodsReferenceValidator;
import fpml.consolidated.com.validation.exists.CalculationPeriodsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationPeriodsReference.class)
public class CalculationPeriodsReferenceMeta implements RosettaMetaData<CalculationPeriodsReference> {

	@Override
	public List<Validator<? super CalculationPeriodsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodsReference> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriodsReference>create(CalculationPeriodsReferenceValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriodsReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriodsReference>create(CalculationPeriodsReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodsReference> validator() {
		return new CalculationPeriodsReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodsReference> typeFormatValidator() {
		return new CalculationPeriodsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodsReference, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodsReferenceOnlyExistsValidator();
	}
}
