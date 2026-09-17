package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.VerificationStatusNotification;
import fpml.consolidated.msg.validation.VerificationStatusNotificationTypeFormatValidator;
import fpml.consolidated.msg.validation.VerificationStatusNotificationValidator;
import fpml.consolidated.msg.validation.exists.VerificationStatusNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VerificationStatusNotification.class)
public class VerificationStatusNotificationMeta implements RosettaMetaData<VerificationStatusNotification> {

	@Override
	public List<Validator<? super VerificationStatusNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VerificationStatusNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VerificationStatusNotification> validator(ValidatorFactory factory) {
		return factory.<VerificationStatusNotification>create(VerificationStatusNotificationValidator.class);
	}

	@Override
	public Validator<? super VerificationStatusNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VerificationStatusNotification>create(VerificationStatusNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VerificationStatusNotification> validator() {
		return new VerificationStatusNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VerificationStatusNotification> typeFormatValidator() {
		return new VerificationStatusNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VerificationStatusNotification, Set<String>> onlyExistsValidator() {
		return new VerificationStatusNotificationOnlyExistsValidator();
	}
}
