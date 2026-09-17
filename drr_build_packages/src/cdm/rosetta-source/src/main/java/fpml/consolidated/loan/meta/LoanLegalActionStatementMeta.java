package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionStatement;
import fpml.consolidated.loan.validation.LoanLegalActionStatementTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionStatementValidator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionStatementChoice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionStatement.class)
public class LoanLegalActionStatementMeta implements RosettaMetaData<LoanLegalActionStatement> {

	@Override
	public List<Validator<? super LoanLegalActionStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionStatement>create(LoanLegalActionStatementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionStatement> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatement>create(LoanLegalActionStatementValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionStatement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatement>create(LoanLegalActionStatementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatement> validator() {
		return new LoanLegalActionStatementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatement> typeFormatValidator() {
		return new LoanLegalActionStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionStatement, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionStatementOnlyExistsValidator();
	}
}
