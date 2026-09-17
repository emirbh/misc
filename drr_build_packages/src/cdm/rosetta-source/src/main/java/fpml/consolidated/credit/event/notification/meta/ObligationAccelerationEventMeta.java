package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.ObligationAccelerationEvent;
import fpml.consolidated.credit.event.notification.validation.ObligationAccelerationEventTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.ObligationAccelerationEventValidator;
import fpml.consolidated.credit.event.notification.validation.exists.ObligationAccelerationEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObligationAccelerationEvent.class)
public class ObligationAccelerationEventMeta implements RosettaMetaData<ObligationAccelerationEvent> {

	@Override
	public List<Validator<? super ObligationAccelerationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObligationAccelerationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObligationAccelerationEvent> validator(ValidatorFactory factory) {
		return factory.<ObligationAccelerationEvent>create(ObligationAccelerationEventValidator.class);
	}

	@Override
	public Validator<? super ObligationAccelerationEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObligationAccelerationEvent>create(ObligationAccelerationEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObligationAccelerationEvent> validator() {
		return new ObligationAccelerationEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObligationAccelerationEvent> typeFormatValidator() {
		return new ObligationAccelerationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObligationAccelerationEvent, Set<String>> onlyExistsValidator() {
		return new ObligationAccelerationEventOnlyExistsValidator();
	}
}
