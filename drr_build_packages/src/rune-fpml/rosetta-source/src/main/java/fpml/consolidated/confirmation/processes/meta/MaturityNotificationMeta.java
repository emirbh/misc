package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.MaturityNotification;
import fpml.consolidated.confirmation.processes.validation.MaturityNotificationTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.MaturityNotificationValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.MaturityNotificationChoice;
import fpml.consolidated.confirmation.processes.validation.exists.MaturityNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MaturityNotification.class)
public class MaturityNotificationMeta implements RosettaMetaData<MaturityNotification> {

	@Override
	public List<Validator<? super MaturityNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MaturityNotification>create(MaturityNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MaturityNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MaturityNotification> validator(ValidatorFactory factory) {
		return factory.<MaturityNotification>create(MaturityNotificationValidator.class);
	}

	@Override
	public Validator<? super MaturityNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MaturityNotification>create(MaturityNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MaturityNotification> validator() {
		return new MaturityNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MaturityNotification> typeFormatValidator() {
		return new MaturityNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaturityNotification, Set<String>> onlyExistsValidator() {
		return new MaturityNotificationOnlyExistsValidator();
	}
}
