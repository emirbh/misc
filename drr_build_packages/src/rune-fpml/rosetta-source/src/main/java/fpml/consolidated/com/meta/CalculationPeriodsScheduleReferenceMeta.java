package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.validation.CalculationPeriodsScheduleReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.CalculationPeriodsScheduleReferenceValidator;
import fpml.consolidated.com.validation.exists.CalculationPeriodsScheduleReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationPeriodsScheduleReference.class)
public class CalculationPeriodsScheduleReferenceMeta implements RosettaMetaData<CalculationPeriodsScheduleReference> {

	@Override
	public List<Validator<? super CalculationPeriodsScheduleReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodsScheduleReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodsScheduleReference> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriodsScheduleReference>create(CalculationPeriodsScheduleReferenceValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriodsScheduleReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriodsScheduleReference>create(CalculationPeriodsScheduleReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodsScheduleReference> validator() {
		return new CalculationPeriodsScheduleReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodsScheduleReference> typeFormatValidator() {
		return new CalculationPeriodsScheduleReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodsScheduleReference, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodsScheduleReferenceOnlyExistsValidator();
	}
}
