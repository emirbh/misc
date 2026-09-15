package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.validation.ObservationEventTypeFormatValidator;
import fpml.consolidated.business.events.validation.ObservationEventValidator;
import fpml.consolidated.business.events.validation.exists.ObservationEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservationEvent.class)
public class ObservationEventMeta implements RosettaMetaData<ObservationEvent> {

	@Override
	public List<Validator<? super ObservationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationEvent> validator(ValidatorFactory factory) {
		return factory.<ObservationEvent>create(ObservationEventValidator.class);
	}

	@Override
	public Validator<? super ObservationEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservationEvent>create(ObservationEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservationEvent> validator() {
		return new ObservationEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservationEvent> typeFormatValidator() {
		return new ObservationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationEvent, Set<String>> onlyExistsValidator() {
		return new ObservationEventOnlyExistsValidator();
	}
}
