package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanBulkServicingNotificationSequence;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationSequenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanBulkServicingNotificationSequenceValidator;
import fpml.consolidated.loan.validation.datarule.LoanBulkServicingNotificationSequenceChoice0;
import fpml.consolidated.loan.validation.datarule.LoanBulkServicingNotificationSequenceChoice1;
import fpml.consolidated.loan.validation.exists.LoanBulkServicingNotificationSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanBulkServicingNotificationSequence.class)
public class LoanBulkServicingNotificationSequenceMeta implements RosettaMetaData<LoanBulkServicingNotificationSequence> {

	@Override
	public List<Validator<? super LoanBulkServicingNotificationSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanBulkServicingNotificationSequence>create(LoanBulkServicingNotificationSequenceChoice0.class),
			factory.<LoanBulkServicingNotificationSequence>create(LoanBulkServicingNotificationSequenceChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super LoanBulkServicingNotificationSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanBulkServicingNotificationSequence> validator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotificationSequence>create(LoanBulkServicingNotificationSequenceValidator.class);
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanBulkServicingNotificationSequence>create(LoanBulkServicingNotificationSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotificationSequence> validator() {
		return new LoanBulkServicingNotificationSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanBulkServicingNotificationSequence> typeFormatValidator() {
		return new LoanBulkServicingNotificationSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanBulkServicingNotificationSequence, Set<String>> onlyExistsValidator() {
		return new LoanBulkServicingNotificationSequenceOnlyExistsValidator();
	}
}
