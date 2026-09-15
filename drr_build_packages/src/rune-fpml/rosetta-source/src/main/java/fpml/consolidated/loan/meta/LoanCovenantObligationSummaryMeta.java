package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.LoanCovenantObligationSummary;
import fpml.consolidated.loan.validation.LoanCovenantObligationSummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationSummaryValidator;
import fpml.consolidated.loan.validation.datarule.CovenantObligationIdentifierChoice;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationSummaryChoice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationSummary.class)
public class LoanCovenantObligationSummaryMeta implements RosettaMetaData<LoanCovenantObligationSummary> {

	@Override
	public List<Validator<? super LoanCovenantObligationSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CovenantObligationIdentifier>create(CovenantObligationIdentifierChoice.class),
			factory.<LoanCovenantObligationSummary>create(LoanCovenantObligationSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationSummary> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationSummary>create(LoanCovenantObligationSummaryValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationSummary>create(LoanCovenantObligationSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationSummary> validator() {
		return new LoanCovenantObligationSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationSummary> typeFormatValidator() {
		return new LoanCovenantObligationSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationSummary, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationSummaryOnlyExistsValidator();
	}
}
