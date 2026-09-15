package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanBulkServicingNotification;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationValidator;
import fpml.consolidated.loan.validation.exists.LoanBulkServicingNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanBulkServicingNotification.class)
public class LoanBulkServicingNotificationMeta implements RosettaMetaData<LoanBulkServicingNotification> {

	@Override
	public List<Validator<? super LoanBulkServicingNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanBulkServicingNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanBulkServicingNotification> validator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotification>create(LoanBulkServicingNotificationValidator.class);
	}

	@Override
	public Validator<? super LoanBulkServicingNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotification>create(LoanBulkServicingNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotification> validator() {
		return new LoanBulkServicingNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotification> typeFormatValidator() {
		return new LoanBulkServicingNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanBulkServicingNotification, Set<String>> onlyExistsValidator() {
		return new LoanBulkServicingNotificationOnlyExistsValidator();
	}
}
