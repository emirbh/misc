package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanPartyProfileStatement;
import fpml.consolidated.loan.validation.LoanPartyProfileStatementTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanPartyProfileStatementValidator;
import fpml.consolidated.loan.validation.exists.LoanPartyProfileStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanPartyProfileStatement.class)
public class LoanPartyProfileStatementMeta implements RosettaMetaData<LoanPartyProfileStatement> {

	@Override
	public List<Validator<? super LoanPartyProfileStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanPartyProfileStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanPartyProfileStatement> validator(ValidatorFactory factory) {
		return factory.<LoanPartyProfileStatement>create(LoanPartyProfileStatementValidator.class);
	}

	@Override
	public Validator<? super LoanPartyProfileStatement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanPartyProfileStatement>create(LoanPartyProfileStatementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanPartyProfileStatement> validator() {
		return new LoanPartyProfileStatementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanPartyProfileStatement> typeFormatValidator() {
		return new LoanPartyProfileStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanPartyProfileStatement, Set<String>> onlyExistsValidator() {
		return new LoanPartyProfileStatementOnlyExistsValidator();
	}
}
