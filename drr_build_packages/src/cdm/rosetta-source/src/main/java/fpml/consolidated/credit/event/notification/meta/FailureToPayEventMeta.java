package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.FailureToPayEvent;
import fpml.consolidated.credit.event.notification.validation.FailureToPayEventTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.FailureToPayEventValidator;
import fpml.consolidated.credit.event.notification.validation.exists.FailureToPayEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FailureToPayEvent.class)
public class FailureToPayEventMeta implements RosettaMetaData<FailureToPayEvent> {

	@Override
	public List<Validator<? super FailureToPayEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FailureToPayEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FailureToPayEvent> validator(ValidatorFactory factory) {
		return factory.<FailureToPayEvent>create(FailureToPayEventValidator.class);
	}

	@Override
	public Validator<? super FailureToPayEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FailureToPayEvent>create(FailureToPayEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FailureToPayEvent> validator() {
		return new FailureToPayEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FailureToPayEvent> typeFormatValidator() {
		return new FailureToPayEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FailureToPayEvent, Set<String>> onlyExistsValidator() {
		return new FailureToPayEventOnlyExistsValidator();
	}
}
