package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ServiceProcessingEvent;
import fpml.consolidated.msg.validation.ServiceProcessingEventTypeFormatValidator;
import fpml.consolidated.msg.validation.ServiceProcessingEventValidator;
import fpml.consolidated.msg.validation.exists.ServiceProcessingEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ServiceProcessingEvent.class)
public class ServiceProcessingEventMeta implements RosettaMetaData<ServiceProcessingEvent> {

	@Override
	public List<Validator<? super ServiceProcessingEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceProcessingEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ServiceProcessingEvent> validator(ValidatorFactory factory) {
		return factory.<ServiceProcessingEvent>create(ServiceProcessingEventValidator.class);
	}

	@Override
	public Validator<? super ServiceProcessingEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ServiceProcessingEvent>create(ServiceProcessingEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ServiceProcessingEvent> validator() {
		return new ServiceProcessingEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ServiceProcessingEvent> typeFormatValidator() {
		return new ServiceProcessingEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceProcessingEvent, Set<String>> onlyExistsValidator() {
		return new ServiceProcessingEventOnlyExistsValidator();
	}
}
