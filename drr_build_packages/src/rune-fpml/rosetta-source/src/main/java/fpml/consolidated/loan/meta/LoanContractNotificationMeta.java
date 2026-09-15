package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanContractNotification;
import fpml.consolidated.loan.validation.LoanContractNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanContractNotificationValidator;
import fpml.consolidated.loan.validation.datarule.LoanContractNotificationChoice0;
import fpml.consolidated.loan.validation.datarule.LoanContractNotificationChoice1;
import fpml.consolidated.loan.validation.exists.LoanContractNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanContractNotification.class)
public class LoanContractNotificationMeta implements RosettaMetaData<LoanContractNotification> {

	@Override
	public List<Validator<? super LoanContractNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanContractNotification>create(LoanContractNotificationChoice0.class),
			factory.<LoanContractNotification>create(LoanContractNotificationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super LoanContractNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanContractNotification> validator(ValidatorFactory factory) {
		return factory.<LoanContractNotification>create(LoanContractNotificationValidator.class);
	}

	@Override
	public Validator<? super LoanContractNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanContractNotification>create(LoanContractNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractNotification> validator() {
		return new LoanContractNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanContractNotification> typeFormatValidator() {
		return new LoanContractNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractNotification, Set<String>> onlyExistsValidator() {
		return new LoanContractNotificationOnlyExistsValidator();
	}
}
