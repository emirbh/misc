package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationNotification;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationNotification.class)
public class LoanCovenantObligationNotificationMeta implements RosettaMetaData<LoanCovenantObligationNotification> {

	@Override
	public List<Validator<? super LoanCovenantObligationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationNotification> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotification>create(LoanCovenantObligationNotificationValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotification>create(LoanCovenantObligationNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotification> validator() {
		return new LoanCovenantObligationNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotification> typeFormatValidator() {
		return new LoanCovenantObligationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationNotification, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationNotificationOnlyExistsValidator();
	}
}
