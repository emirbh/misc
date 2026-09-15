package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationAccountingDetails;
import fpml.consolidated.loan.validation.LoanCovenantObligationAccountingDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationAccountingDetailsValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationAccountingDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationAccountingDetails.class)
public class LoanCovenantObligationAccountingDetailsMeta implements RosettaMetaData<LoanCovenantObligationAccountingDetails> {

	@Override
	public List<Validator<? super LoanCovenantObligationAccountingDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationAccountingDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationAccountingDetails> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationAccountingDetails>create(LoanCovenantObligationAccountingDetailsValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationAccountingDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationAccountingDetails>create(LoanCovenantObligationAccountingDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationAccountingDetails> validator() {
		return new LoanCovenantObligationAccountingDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationAccountingDetails> typeFormatValidator() {
		return new LoanCovenantObligationAccountingDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationAccountingDetails, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationAccountingDetailsOnlyExistsValidator();
	}
}
