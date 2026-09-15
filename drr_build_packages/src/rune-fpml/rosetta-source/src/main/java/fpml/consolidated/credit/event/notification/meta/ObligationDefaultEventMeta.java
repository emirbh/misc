package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.ObligationDefaultEvent;
import fpml.consolidated.credit.event.notification.validation.ObligationDefaultEventTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.ObligationDefaultEventValidator;
import fpml.consolidated.credit.event.notification.validation.exists.ObligationDefaultEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObligationDefaultEvent.class)
public class ObligationDefaultEventMeta implements RosettaMetaData<ObligationDefaultEvent> {

	@Override
	public List<Validator<? super ObligationDefaultEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObligationDefaultEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObligationDefaultEvent> validator(ValidatorFactory factory) {
		return factory.<ObligationDefaultEvent>create(ObligationDefaultEventValidator.class);
	}

	@Override
	public Validator<? super ObligationDefaultEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObligationDefaultEvent>create(ObligationDefaultEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObligationDefaultEvent> validator() {
		return new ObligationDefaultEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObligationDefaultEvent> typeFormatValidator() {
		return new ObligationDefaultEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObligationDefaultEvent, Set<String>> onlyExistsValidator() {
		return new ObligationDefaultEventOnlyExistsValidator();
	}
}
