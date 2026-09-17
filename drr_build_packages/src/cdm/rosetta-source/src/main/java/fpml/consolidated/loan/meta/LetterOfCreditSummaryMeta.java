package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ContractIdentifier;
import fpml.consolidated.doc.validation.datarule.ContractIdentifierChoice;
import fpml.consolidated.loan.LetterOfCreditSummary;
import fpml.consolidated.loan.validation.LetterOfCreditSummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.LetterOfCreditSummaryValidator;
import fpml.consolidated.loan.validation.exists.LetterOfCreditSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LetterOfCreditSummary.class)
public class LetterOfCreditSummaryMeta implements RosettaMetaData<LetterOfCreditSummary> {

	@Override
	public List<Validator<? super LetterOfCreditSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ContractIdentifier>create(ContractIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LetterOfCreditSummary> validator(ValidatorFactory factory) {
		return factory.<LetterOfCreditSummary>create(LetterOfCreditSummaryValidator.class);
	}

	@Override
	public Validator<? super LetterOfCreditSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LetterOfCreditSummary>create(LetterOfCreditSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCreditSummary> validator() {
		return new LetterOfCreditSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LetterOfCreditSummary> typeFormatValidator() {
		return new LetterOfCreditSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditSummary, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditSummaryOnlyExistsValidator();
	}
}
