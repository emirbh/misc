package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ApprovalStatusNotification;
import fpml.consolidated.confirmation.processes.validation.ApprovalStatusNotificationTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ApprovalStatusNotificationValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ApprovalStatusNotificationChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ApprovalStatusNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApprovalStatusNotification.class)
public class ApprovalStatusNotificationMeta implements RosettaMetaData<ApprovalStatusNotification> {

	@Override
	public List<Validator<? super ApprovalStatusNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ApprovalStatusNotification>create(ApprovalStatusNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApprovalStatusNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApprovalStatusNotification> validator(ValidatorFactory factory) {
		return factory.<ApprovalStatusNotification>create(ApprovalStatusNotificationValidator.class);
	}

	@Override
	public Validator<? super ApprovalStatusNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApprovalStatusNotification>create(ApprovalStatusNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalStatusNotification> validator() {
		return new ApprovalStatusNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalStatusNotification> typeFormatValidator() {
		return new ApprovalStatusNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalStatusNotification, Set<String>> onlyExistsValidator() {
		return new ApprovalStatusNotificationOnlyExistsValidator();
	}
}
