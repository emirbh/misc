package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetails;
import fpml.consolidated.loan.validation.LoanCovenantObligationDateTriggerDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationDateTriggerDetailsValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationDateTriggerDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationDateTriggerDetails.class)
public class LoanCovenantObligationDateTriggerDetailsMeta implements RosettaMetaData<LoanCovenantObligationDateTriggerDetails> {

	@Override
	public List<Validator<? super LoanCovenantObligationDateTriggerDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationDateTriggerDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetails> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationDateTriggerDetails>create(LoanCovenantObligationDateTriggerDetailsValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationDateTriggerDetails>create(LoanCovenantObligationDateTriggerDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetails> validator() {
		return new LoanCovenantObligationDateTriggerDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetails> typeFormatValidator() {
		return new LoanCovenantObligationDateTriggerDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationDateTriggerDetails, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationDateTriggerDetailsOnlyExistsValidator();
	}
}
