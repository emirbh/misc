package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanBulkServicingNotificationSequenceChoice;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationSequenceChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationSequenceChoiceValidator;
import fpml.consolidated.loan.validation.datarule.LoanBulkServicingNotificationSequenceChoiceChoice;
import fpml.consolidated.loan.validation.exists.LoanBulkServicingNotificationSequenceChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanBulkServicingNotificationSequenceChoice.class)
public class LoanBulkServicingNotificationSequenceChoiceMeta implements RosettaMetaData<LoanBulkServicingNotificationSequenceChoice> {

	@Override
	public List<Validator<? super LoanBulkServicingNotificationSequenceChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanBulkServicingNotificationSequenceChoice>create(LoanBulkServicingNotificationSequenceChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanBulkServicingNotificationSequenceChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanBulkServicingNotificationSequenceChoice> validator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotificationSequenceChoice>create(LoanBulkServicingNotificationSequenceChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationSequenceChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotificationSequenceChoice>create(LoanBulkServicingNotificationSequenceChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotificationSequenceChoice> validator() {
		return new LoanBulkServicingNotificationSequenceChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotificationSequenceChoice> typeFormatValidator() {
		return new LoanBulkServicingNotificationSequenceChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanBulkServicingNotificationSequenceChoice, Set<String>> onlyExistsValidator() {
		return new LoanBulkServicingNotificationSequenceChoiceOnlyExistsValidator();
	}
}
