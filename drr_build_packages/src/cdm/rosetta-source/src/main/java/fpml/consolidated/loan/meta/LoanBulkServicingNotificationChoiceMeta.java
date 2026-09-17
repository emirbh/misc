package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanBulkServicingNotificationChoice;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationChoiceValidator;
import fpml.consolidated.loan.validation.datarule.LoanBulkServicingNotificationChoiceChoice;
import fpml.consolidated.loan.validation.exists.LoanBulkServicingNotificationChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanBulkServicingNotificationChoice.class)
public class LoanBulkServicingNotificationChoiceMeta implements RosettaMetaData<LoanBulkServicingNotificationChoice> {

	@Override
	public List<Validator<? super LoanBulkServicingNotificationChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanBulkServicingNotificationChoice>create(LoanBulkServicingNotificationChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanBulkServicingNotificationChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanBulkServicingNotificationChoice> validator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotificationChoice>create(LoanBulkServicingNotificationChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotificationChoice>create(LoanBulkServicingNotificationChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotificationChoice> validator() {
		return new LoanBulkServicingNotificationChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotificationChoice> typeFormatValidator() {
		return new LoanBulkServicingNotificationChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanBulkServicingNotificationChoice, Set<String>> onlyExistsValidator() {
		return new LoanBulkServicingNotificationChoiceOnlyExistsValidator();
	}
}
