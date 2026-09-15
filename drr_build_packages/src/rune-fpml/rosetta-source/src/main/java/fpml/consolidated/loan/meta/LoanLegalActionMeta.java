package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegalActionIdentifier;
import fpml.consolidated.loan.LoanLegalAction;
import fpml.consolidated.loan.LoanLegalActionSummary;
import fpml.consolidated.loan.validation.LoanLegalActionTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionValidator;
import fpml.consolidated.loan.validation.datarule.LegalActionIdentifierChoice;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionSummaryChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalAction.class)
public class LoanLegalActionMeta implements RosettaMetaData<LoanLegalAction> {

	@Override
	public List<Validator<? super LoanLegalAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegalActionIdentifier>create(LegalActionIdentifierChoice.class),
			factory.<LoanLegalActionSummary>create(LoanLegalActionSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalAction> validator(ValidatorFactory factory) {
		return factory.<LoanLegalAction>create(LoanLegalActionValidator.class);
	}

	@Override
	public Validator<? super LoanLegalAction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalAction>create(LoanLegalActionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalAction> validator() {
		return new LoanLegalActionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalAction> typeFormatValidator() {
		return new LoanLegalActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalAction, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionOnlyExistsValidator();
	}
}
