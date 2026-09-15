package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ExecutionNotification;
import fpml.consolidated.confirmation.processes.validation.ExecutionNotificationTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ExecutionNotificationValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ExecutionNotificationChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ExecutionNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionNotification.class)
public class ExecutionNotificationMeta implements RosettaMetaData<ExecutionNotification> {

	@Override
	public List<Validator<? super ExecutionNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExecutionNotification>create(ExecutionNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionNotification> validator(ValidatorFactory factory) {
		return factory.<ExecutionNotification>create(ExecutionNotificationValidator.class);
	}

	@Override
	public Validator<? super ExecutionNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionNotification>create(ExecutionNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionNotification> validator() {
		return new ExecutionNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionNotification> typeFormatValidator() {
		return new ExecutionNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionNotification, Set<String>> onlyExistsValidator() {
		return new ExecutionNotificationOnlyExistsValidator();
	}
}
