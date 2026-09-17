package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationMetricSequence;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricSequenceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationMetricSequenceValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationMetricSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationMetricSequence.class)
public class LoanCovenantObligationMetricSequenceMeta implements RosettaMetaData<LoanCovenantObligationMetricSequence> {

	@Override
	public List<Validator<? super LoanCovenantObligationMetricSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationMetricSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationMetricSequence> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricSequence>create(LoanCovenantObligationMetricSequenceValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationMetricSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationMetricSequence>create(LoanCovenantObligationMetricSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricSequence> validator() {
		return new LoanCovenantObligationMetricSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationMetricSequence> typeFormatValidator() {
		return new LoanCovenantObligationMetricSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationMetricSequence, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationMetricSequenceOnlyExistsValidator();
	}
}
