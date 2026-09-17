package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice1;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoiceChoice1TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoiceChoice1Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionNotificationChoiceChoice1Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionNotificationChoiceChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionNotificationChoiceChoice1.class)
public class LoanLegalActionNotificationChoiceChoice1Meta implements RosettaMetaData<LoanLegalActionNotificationChoiceChoice1> {

	@Override
	public List<Validator<? super LoanLegalActionNotificationChoiceChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionNotificationChoiceChoice1>create(LoanLegalActionNotificationChoiceChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionNotificationChoiceChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice1> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoiceChoice1>create(LoanLegalActionNotificationChoiceChoice1Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoiceChoice1>create(LoanLegalActionNotificationChoiceChoice1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice1> validator() {
		return new LoanLegalActionNotificationChoiceChoice1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice1> typeFormatValidator() {
		return new LoanLegalActionNotificationChoiceChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionNotificationChoiceChoice1, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionNotificationChoiceChoice1OnlyExistsValidator();
	}
}
