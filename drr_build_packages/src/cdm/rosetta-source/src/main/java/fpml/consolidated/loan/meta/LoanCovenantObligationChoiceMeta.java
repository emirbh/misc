package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationChoice;
import fpml.consolidated.loan.validation.LoanCovenantObligationChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationChoiceValidator;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationChoiceChoice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationChoice.class)
public class LoanCovenantObligationChoiceMeta implements RosettaMetaData<LoanCovenantObligationChoice> {

	@Override
	public List<Validator<? super LoanCovenantObligationChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanCovenantObligationChoice>create(LoanCovenantObligationChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationChoice> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationChoice>create(LoanCovenantObligationChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationChoice>create(LoanCovenantObligationChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationChoice> validator() {
		return new LoanCovenantObligationChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationChoice> typeFormatValidator() {
		return new LoanCovenantObligationChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationChoice, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationChoiceOnlyExistsValidator();
	}
}
