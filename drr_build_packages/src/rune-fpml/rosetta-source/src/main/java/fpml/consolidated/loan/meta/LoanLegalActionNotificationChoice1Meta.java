package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionNotificationChoice1;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoice1TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoice1Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionNotificationChoice1Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionNotificationChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionNotificationChoice1.class)
public class LoanLegalActionNotificationChoice1Meta implements RosettaMetaData<LoanLegalActionNotificationChoice1> {

	@Override
	public List<Validator<? super LoanLegalActionNotificationChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionNotificationChoice1>create(LoanLegalActionNotificationChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionNotificationChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionNotificationChoice1> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoice1>create(LoanLegalActionNotificationChoice1Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionNotificationChoice1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoice1>create(LoanLegalActionNotificationChoice1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoice1> validator() {
		return new LoanLegalActionNotificationChoice1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoice1> typeFormatValidator() {
		return new LoanLegalActionNotificationChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionNotificationChoice1, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionNotificationChoice1OnlyExistsValidator();
	}
}
