package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TouchRateObservation;
import fpml.consolidated.business.events.TriggerRateObservation;
import fpml.consolidated.business.events.validation.TouchRateObservationTypeFormatValidator;
import fpml.consolidated.business.events.validation.TouchRateObservationValidator;
import fpml.consolidated.business.events.validation.datarule.TouchRateObservationChoice0;
import fpml.consolidated.business.events.validation.datarule.TouchRateObservationChoice1;
import fpml.consolidated.business.events.validation.datarule.TriggerRateObservationChoice;
import fpml.consolidated.business.events.validation.exists.TouchRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TouchRateObservation.class)
public class TouchRateObservationMeta implements RosettaMetaData<TouchRateObservation> {

	@Override
	public List<Validator<? super TouchRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TriggerRateObservation>create(TriggerRateObservationChoice.class),
			factory.<TouchRateObservation>create(TouchRateObservationChoice0.class),
			factory.<TouchRateObservation>create(TouchRateObservationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super TouchRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TouchRateObservation> validator(ValidatorFactory factory) {
		return factory.<TouchRateObservation>create(TouchRateObservationValidator.class);
	}

	@Override
	public Validator<? super TouchRateObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TouchRateObservation>create(TouchRateObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TouchRateObservation> validator() {
		return new TouchRateObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TouchRateObservation> typeFormatValidator() {
		return new TouchRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TouchRateObservation, Set<String>> onlyExistsValidator() {
		return new TouchRateObservationOnlyExistsValidator();
	}
}
