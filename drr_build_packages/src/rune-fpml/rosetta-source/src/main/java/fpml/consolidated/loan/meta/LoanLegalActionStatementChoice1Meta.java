package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionStatementChoice1;
import fpml.consolidated.loan.validation.LoanLegalActionStatementChoice1TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionStatementChoice1Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionStatementChoice1Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionStatementChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionStatementChoice1.class)
public class LoanLegalActionStatementChoice1Meta implements RosettaMetaData<LoanLegalActionStatementChoice1> {

	@Override
	public List<Validator<? super LoanLegalActionStatementChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionStatementChoice1>create(LoanLegalActionStatementChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionStatementChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionStatementChoice1> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatementChoice1>create(LoanLegalActionStatementChoice1Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionStatementChoice1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatementChoice1>create(LoanLegalActionStatementChoice1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatementChoice1> validator() {
		return new LoanLegalActionStatementChoice1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatementChoice1> typeFormatValidator() {
		return new LoanLegalActionStatementChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionStatementChoice1, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionStatementChoice1OnlyExistsValidator();
	}
}
