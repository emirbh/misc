package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice1;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationChoice1TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationChoice1Validator;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationNotificationChoice1Choice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationNotificationChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationNotificationChoice1.class)
public class LoanCovenantObligationNotificationChoice1Meta implements RosettaMetaData<LoanCovenantObligationNotificationChoice1> {

	@Override
	public List<Validator<? super LoanCovenantObligationNotificationChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanCovenantObligationNotificationChoice1>create(LoanCovenantObligationNotificationChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationNotificationChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice1> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotificationChoice1>create(LoanCovenantObligationNotificationChoice1Validator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotificationChoice1>create(LoanCovenantObligationNotificationChoice1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice1> validator() {
		return new LoanCovenantObligationNotificationChoice1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice1> typeFormatValidator() {
		return new LoanCovenantObligationNotificationChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationNotificationChoice1, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationNotificationChoice1OnlyExistsValidator();
	}
}
