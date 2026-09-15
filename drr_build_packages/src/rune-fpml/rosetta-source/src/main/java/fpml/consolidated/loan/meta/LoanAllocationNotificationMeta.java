package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationNotification;
import fpml.consolidated.loan.validation.LoanAllocationNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationNotificationValidator;
import fpml.consolidated.loan.validation.datarule.LoanAllocationNotificationChoice0;
import fpml.consolidated.loan.validation.datarule.LoanAllocationNotificationChoice1;
import fpml.consolidated.loan.validation.datarule.LoanAllocationNotificationChoice2;
import fpml.consolidated.loan.validation.exists.LoanAllocationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationNotification.class)
public class LoanAllocationNotificationMeta implements RosettaMetaData<LoanAllocationNotification> {

	@Override
	public List<Validator<? super LoanAllocationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanAllocationNotification>create(LoanAllocationNotificationChoice0.class),
			factory.<LoanAllocationNotification>create(LoanAllocationNotificationChoice1.class),
			factory.<LoanAllocationNotification>create(LoanAllocationNotificationChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationNotification> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotification>create(LoanAllocationNotificationValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationNotification>create(LoanAllocationNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotification> validator() {
		return new LoanAllocationNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNotification> typeFormatValidator() {
		return new LoanAllocationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNotificationOnlyExistsValidator();
	}
}
