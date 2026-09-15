package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanAllocationNotification;
import fpml.consolidated.loan.validation.AbstractLoanAllocationNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanAllocationNotificationValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanAllocationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanAllocationNotification.class)
public class AbstractLoanAllocationNotificationMeta implements RosettaMetaData<AbstractLoanAllocationNotification> {

	@Override
	public List<Validator<? super AbstractLoanAllocationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanAllocationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanAllocationNotification> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanAllocationNotification>create(AbstractLoanAllocationNotificationValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanAllocationNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanAllocationNotification>create(AbstractLoanAllocationNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanAllocationNotification> validator() {
		return new AbstractLoanAllocationNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanAllocationNotification> typeFormatValidator() {
		return new AbstractLoanAllocationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanAllocationNotification, Set<String>> onlyExistsValidator() {
		return new AbstractLoanAllocationNotificationOnlyExistsValidator();
	}
}
