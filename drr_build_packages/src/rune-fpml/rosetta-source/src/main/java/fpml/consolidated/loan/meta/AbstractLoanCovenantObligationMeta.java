package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanCovenantObligation;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.LoanCovenantObligationSummary;
import fpml.consolidated.loan.validation.AbstractLoanCovenantObligationTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanCovenantObligationValidator;
import fpml.consolidated.loan.validation.datarule.CovenantObligationIdentifierChoice;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationSummaryChoice;
import fpml.consolidated.loan.validation.exists.AbstractLoanCovenantObligationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanCovenantObligation.class)
public class AbstractLoanCovenantObligationMeta implements RosettaMetaData<AbstractLoanCovenantObligation> {

	@Override
	public List<Validator<? super AbstractLoanCovenantObligation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CovenantObligationIdentifier>create(CovenantObligationIdentifierChoice.class),
			factory.<LoanCovenantObligationSummary>create(LoanCovenantObligationSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanCovenantObligation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanCovenantObligation> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanCovenantObligation>create(AbstractLoanCovenantObligationValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanCovenantObligation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanCovenantObligation>create(AbstractLoanCovenantObligationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanCovenantObligation> validator() {
		return new AbstractLoanCovenantObligationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanCovenantObligation> typeFormatValidator() {
		return new AbstractLoanCovenantObligationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanCovenantObligation, Set<String>> onlyExistsValidator() {
		return new AbstractLoanCovenantObligationOnlyExistsValidator();
	}
}
