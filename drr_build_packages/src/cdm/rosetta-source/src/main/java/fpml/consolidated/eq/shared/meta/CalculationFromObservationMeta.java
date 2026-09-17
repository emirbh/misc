package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.CalculationFromObservation;
import fpml.consolidated.eq.shared.validation.CalculationFromObservationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.CalculationFromObservationValidator;
import fpml.consolidated.eq.shared.validation.datarule.CalculationFromObservationChoice;
import fpml.consolidated.eq.shared.validation.exists.CalculationFromObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationFromObservation.class)
public class CalculationFromObservationMeta implements RosettaMetaData<CalculationFromObservation> {

	@Override
	public List<Validator<? super CalculationFromObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationFromObservation>create(CalculationFromObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationFromObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationFromObservation> validator(ValidatorFactory factory) {
		return factory.<CalculationFromObservation>create(CalculationFromObservationValidator.class);
	}

	@Override
	public Validator<? super CalculationFromObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationFromObservation>create(CalculationFromObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationFromObservation> validator() {
		return new CalculationFromObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationFromObservation> typeFormatValidator() {
		return new CalculationFromObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationFromObservation, Set<String>> onlyExistsValidator() {
		return new CalculationFromObservationOnlyExistsValidator();
	}
}
