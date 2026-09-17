package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ExecutionNotification;
import fpml.consolidated.confirmation.processes.OptionExpirationNotification;
import fpml.consolidated.confirmation.processes.validation.OptionExpirationNotificationTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.OptionExpirationNotificationValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ExecutionNotificationChoice;
import fpml.consolidated.confirmation.processes.validation.exists.OptionExpirationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionExpirationNotification.class)
public class OptionExpirationNotificationMeta implements RosettaMetaData<OptionExpirationNotification> {

	@Override
	public List<Validator<? super OptionExpirationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExecutionNotification>create(ExecutionNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExpirationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionExpirationNotification> validator(ValidatorFactory factory) {
		return factory.<OptionExpirationNotification>create(OptionExpirationNotificationValidator.class);
	}

	@Override
	public Validator<? super OptionExpirationNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionExpirationNotification>create(OptionExpirationNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionExpirationNotification> validator() {
		return new OptionExpirationNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionExpirationNotification> typeFormatValidator() {
		return new OptionExpirationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExpirationNotification, Set<String>> onlyExistsValidator() {
		return new OptionExpirationNotificationOnlyExistsValidator();
	}
}
