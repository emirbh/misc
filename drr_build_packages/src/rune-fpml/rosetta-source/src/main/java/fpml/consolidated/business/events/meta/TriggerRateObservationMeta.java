package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TriggerRateObservation;
import fpml.consolidated.business.events.validation.TriggerRateObservationTypeFormatValidator;
import fpml.consolidated.business.events.validation.TriggerRateObservationValidator;
import fpml.consolidated.business.events.validation.datarule.TriggerRateObservationChoice;
import fpml.consolidated.business.events.validation.exists.TriggerRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TriggerRateObservation.class)
public class TriggerRateObservationMeta implements RosettaMetaData<TriggerRateObservation> {

	@Override
	public List<Validator<? super TriggerRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TriggerRateObservation>create(TriggerRateObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TriggerRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TriggerRateObservation> validator(ValidatorFactory factory) {
		return factory.<TriggerRateObservation>create(TriggerRateObservationValidator.class);
	}

	@Override
	public Validator<? super TriggerRateObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TriggerRateObservation>create(TriggerRateObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TriggerRateObservation> validator() {
		return new TriggerRateObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TriggerRateObservation> typeFormatValidator() {
		return new TriggerRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriggerRateObservation, Set<String>> onlyExistsValidator() {
		return new TriggerRateObservationOnlyExistsValidator();
	}
}
