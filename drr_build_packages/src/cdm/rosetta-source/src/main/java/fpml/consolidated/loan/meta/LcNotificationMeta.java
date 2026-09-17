package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcNotification;
import fpml.consolidated.loan.validation.LcNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LcNotificationValidator;
import fpml.consolidated.loan.validation.datarule.LcNotificationChoice0;
import fpml.consolidated.loan.validation.datarule.LcNotificationChoice1;
import fpml.consolidated.loan.validation.datarule.LcNotificationChoice2;
import fpml.consolidated.loan.validation.exists.LcNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcNotification.class)
public class LcNotificationMeta implements RosettaMetaData<LcNotification> {

	@Override
	public List<Validator<? super LcNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LcNotification>create(LcNotificationChoice0.class),
			factory.<LcNotification>create(LcNotificationChoice1.class),
			factory.<LcNotification>create(LcNotificationChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super LcNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcNotification> validator(ValidatorFactory factory) {
		return factory.<LcNotification>create(LcNotificationValidator.class);
	}

	@Override
	public Validator<? super LcNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcNotification>create(LcNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcNotification> validator() {
		return new LcNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcNotification> typeFormatValidator() {
		return new LcNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcNotification, Set<String>> onlyExistsValidator() {
		return new LcNotificationOnlyExistsValidator();
	}
}
