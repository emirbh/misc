package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ServiceNotification;
import fpml.consolidated.msg.validation.ServiceNotificationTypeFormatValidator;
import fpml.consolidated.msg.validation.ServiceNotificationValidator;
import fpml.consolidated.msg.validation.datarule.ServiceNotificationChoice;
import fpml.consolidated.msg.validation.exists.ServiceNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ServiceNotification.class)
public class ServiceNotificationMeta implements RosettaMetaData<ServiceNotification> {

	@Override
	public List<Validator<? super ServiceNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ServiceNotification>create(ServiceNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ServiceNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ServiceNotification> validator(ValidatorFactory factory) {
		return factory.<ServiceNotification>create(ServiceNotificationValidator.class);
	}

	@Override
	public Validator<? super ServiceNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ServiceNotification>create(ServiceNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ServiceNotification> validator() {
		return new ServiceNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ServiceNotification> typeFormatValidator() {
		return new ServiceNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceNotification, Set<String>> onlyExistsValidator() {
		return new ServiceNotificationOnlyExistsValidator();
	}
}
