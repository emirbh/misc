package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegalActionIdentifier;
import fpml.consolidated.loan.LoanLegalActionSummary;
import fpml.consolidated.loan.validation.LoanLegalActionSummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionSummaryValidator;
import fpml.consolidated.loan.validation.datarule.LegalActionIdentifierChoice;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionSummaryChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionSummary.class)
public class LoanLegalActionSummaryMeta implements RosettaMetaData<LoanLegalActionSummary> {

	@Override
	public List<Validator<? super LoanLegalActionSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegalActionIdentifier>create(LegalActionIdentifierChoice.class),
			factory.<LoanLegalActionSummary>create(LoanLegalActionSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionSummary> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionSummary>create(LoanLegalActionSummaryValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionSummary>create(LoanLegalActionSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionSummary> validator() {
		return new LoanLegalActionSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionSummary> typeFormatValidator() {
		return new LoanLegalActionSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionSummary, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionSummaryOnlyExistsValidator();
	}
}
