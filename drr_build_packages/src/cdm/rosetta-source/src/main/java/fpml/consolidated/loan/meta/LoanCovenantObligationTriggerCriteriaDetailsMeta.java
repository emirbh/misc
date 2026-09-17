package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationTriggerCriteriaDetails;
import fpml.consolidated.loan.validation.LoanCovenantObligationTriggerCriteriaDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationTriggerCriteriaDetailsValidator;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationTriggerCriteriaDetailsChoice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationTriggerCriteriaDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationTriggerCriteriaDetails.class)
public class LoanCovenantObligationTriggerCriteriaDetailsMeta implements RosettaMetaData<LoanCovenantObligationTriggerCriteriaDetails> {

	@Override
	public List<Validator<? super LoanCovenantObligationTriggerCriteriaDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanCovenantObligationTriggerCriteriaDetails>create(LoanCovenantObligationTriggerCriteriaDetailsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationTriggerCriteriaDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationTriggerCriteriaDetails> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationTriggerCriteriaDetails>create(LoanCovenantObligationTriggerCriteriaDetailsValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationTriggerCriteriaDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationTriggerCriteriaDetails>create(LoanCovenantObligationTriggerCriteriaDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationTriggerCriteriaDetails> validator() {
		return new LoanCovenantObligationTriggerCriteriaDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationTriggerCriteriaDetails> typeFormatValidator() {
		return new LoanCovenantObligationTriggerCriteriaDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationTriggerCriteriaDetails, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationTriggerCriteriaDetailsOnlyExistsValidator();
	}
}
