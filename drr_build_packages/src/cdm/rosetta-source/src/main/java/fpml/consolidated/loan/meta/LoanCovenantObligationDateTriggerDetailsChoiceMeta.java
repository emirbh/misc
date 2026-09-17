package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetailsChoice;
import fpml.consolidated.loan.validation.LoanCovenantObligationDateTriggerDetailsChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationDateTriggerDetailsChoiceValidator;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationDateTriggerDetailsChoiceChoice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationDateTriggerDetailsChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationDateTriggerDetailsChoice.class)
public class LoanCovenantObligationDateTriggerDetailsChoiceMeta implements RosettaMetaData<LoanCovenantObligationDateTriggerDetailsChoice> {

	@Override
	public List<Validator<? super LoanCovenantObligationDateTriggerDetailsChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanCovenantObligationDateTriggerDetailsChoice>create(LoanCovenantObligationDateTriggerDetailsChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationDateTriggerDetailsChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetailsChoice> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationDateTriggerDetailsChoice>create(LoanCovenantObligationDateTriggerDetailsChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetailsChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationDateTriggerDetailsChoice>create(LoanCovenantObligationDateTriggerDetailsChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetailsChoice> validator() {
		return new LoanCovenantObligationDateTriggerDetailsChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationDateTriggerDetailsChoice> typeFormatValidator() {
		return new LoanCovenantObligationDateTriggerDetailsChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationDateTriggerDetailsChoice, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationDateTriggerDetailsChoiceOnlyExistsValidator();
	}
}
