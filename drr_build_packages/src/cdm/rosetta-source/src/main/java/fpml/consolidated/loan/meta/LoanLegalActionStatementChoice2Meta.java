package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionStatementChoice2;
import fpml.consolidated.loan.validation.LoanLegalActionStatementChoice2TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionStatementChoice2Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionStatementChoice2Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionStatementChoice2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionStatementChoice2.class)
public class LoanLegalActionStatementChoice2Meta implements RosettaMetaData<LoanLegalActionStatementChoice2> {

	@Override
	public List<Validator<? super LoanLegalActionStatementChoice2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionStatementChoice2>create(LoanLegalActionStatementChoice2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionStatementChoice2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionStatementChoice2> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatementChoice2>create(LoanLegalActionStatementChoice2Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionStatementChoice2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatementChoice2>create(LoanLegalActionStatementChoice2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatementChoice2> validator() {
		return new LoanLegalActionStatementChoice2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatementChoice2> typeFormatValidator() {
		return new LoanLegalActionStatementChoice2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionStatementChoice2, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionStatementChoice2OnlyExistsValidator();
	}
}
