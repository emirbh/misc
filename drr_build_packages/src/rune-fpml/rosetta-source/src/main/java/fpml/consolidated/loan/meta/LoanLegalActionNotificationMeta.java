package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionNotification;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationValidator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionNotificationChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionNotification.class)
public class LoanLegalActionNotificationMeta implements RosettaMetaData<LoanLegalActionNotification> {

	@Override
	public List<Validator<? super LoanLegalActionNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionNotification>create(LoanLegalActionNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionNotification> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotification>create(LoanLegalActionNotificationValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotification>create(LoanLegalActionNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotification> validator() {
		return new LoanLegalActionNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotification> typeFormatValidator() {
		return new LoanLegalActionNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionNotification, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionNotificationOnlyExistsValidator();
	}
}
