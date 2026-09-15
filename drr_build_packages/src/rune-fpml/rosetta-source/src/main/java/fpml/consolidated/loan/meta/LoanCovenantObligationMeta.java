package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.LoanCovenantObligationSummary;
import fpml.consolidated.loan.validation.LoanCovenantObligationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationValidator;
import fpml.consolidated.loan.validation.datarule.CovenantObligationIdentifierChoice;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationChoice;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationSummaryChoice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligation.class)
public class LoanCovenantObligationMeta implements RosettaMetaData<LoanCovenantObligation> {

	@Override
	public List<Validator<? super LoanCovenantObligation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CovenantObligationIdentifier>create(CovenantObligationIdentifierChoice.class),
			factory.<LoanCovenantObligationSummary>create(LoanCovenantObligationSummaryChoice.class),
			factory.<LoanCovenantObligation>create(LoanCovenantObligationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligation> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligation>create(LoanCovenantObligationValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligation>create(LoanCovenantObligationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligation> validator() {
		return new LoanCovenantObligationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligation> typeFormatValidator() {
		return new LoanCovenantObligationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligation, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationOnlyExistsValidator();
	}
}
