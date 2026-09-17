package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanLegalAction;
import fpml.consolidated.loan.LegalActionIdentifier;
import fpml.consolidated.loan.LoanLegalActionSummary;
import fpml.consolidated.loan.validation.AbstractLoanLegalActionTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanLegalActionValidator;
import fpml.consolidated.loan.validation.datarule.LegalActionIdentifierChoice;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionSummaryChoice;
import fpml.consolidated.loan.validation.exists.AbstractLoanLegalActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanLegalAction.class)
public class AbstractLoanLegalActionMeta implements RosettaMetaData<AbstractLoanLegalAction> {

	@Override
	public List<Validator<? super AbstractLoanLegalAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegalActionIdentifier>create(LegalActionIdentifierChoice.class),
			factory.<LoanLegalActionSummary>create(LoanLegalActionSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanLegalAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanLegalAction> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanLegalAction>create(AbstractLoanLegalActionValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanLegalAction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanLegalAction>create(AbstractLoanLegalActionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanLegalAction> validator() {
		return new AbstractLoanLegalActionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanLegalAction> typeFormatValidator() {
		return new AbstractLoanLegalActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanLegalAction, Set<String>> onlyExistsValidator() {
		return new AbstractLoanLegalActionOnlyExistsValidator();
	}
}
