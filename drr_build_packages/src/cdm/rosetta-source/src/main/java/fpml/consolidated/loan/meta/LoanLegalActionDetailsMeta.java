package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionDetails;
import fpml.consolidated.loan.validation.LoanLegalActionDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionDetailsValidator;
import fpml.consolidated.loan.validation.exists.LoanLegalActionDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionDetails.class)
public class LoanLegalActionDetailsMeta implements RosettaMetaData<LoanLegalActionDetails> {

	@Override
	public List<Validator<? super LoanLegalActionDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionDetails> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionDetails>create(LoanLegalActionDetailsValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionDetails>create(LoanLegalActionDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionDetails> validator() {
		return new LoanLegalActionDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionDetails> typeFormatValidator() {
		return new LoanLegalActionDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionDetails, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionDetailsOnlyExistsValidator();
	}
}
