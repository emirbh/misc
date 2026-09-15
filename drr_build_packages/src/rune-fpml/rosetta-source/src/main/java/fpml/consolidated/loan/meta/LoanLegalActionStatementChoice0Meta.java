package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionStatementChoice0;
import fpml.consolidated.loan.validation.LoanLegalActionStatementChoice0TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionStatementChoice0Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionStatementChoice0Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionStatementChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionStatementChoice0.class)
public class LoanLegalActionStatementChoice0Meta implements RosettaMetaData<LoanLegalActionStatementChoice0> {

	@Override
	public List<Validator<? super LoanLegalActionStatementChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionStatementChoice0>create(LoanLegalActionStatementChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionStatementChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionStatementChoice0> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatementChoice0>create(LoanLegalActionStatementChoice0Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionStatementChoice0> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatementChoice0>create(LoanLegalActionStatementChoice0TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatementChoice0> validator() {
		return new LoanLegalActionStatementChoice0Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatementChoice0> typeFormatValidator() {
		return new LoanLegalActionStatementChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionStatementChoice0, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionStatementChoice0OnlyExistsValidator();
	}
}
