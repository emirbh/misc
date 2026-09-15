package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanPartyProfileStatement;
import fpml.consolidated.loan.validation.AbstractLoanPartyProfileStatementTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanPartyProfileStatementValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanPartyProfileStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanPartyProfileStatement.class)
public class AbstractLoanPartyProfileStatementMeta implements RosettaMetaData<AbstractLoanPartyProfileStatement> {

	@Override
	public List<Validator<? super AbstractLoanPartyProfileStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanPartyProfileStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanPartyProfileStatement> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanPartyProfileStatement>create(AbstractLoanPartyProfileStatementValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanPartyProfileStatement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanPartyProfileStatement>create(AbstractLoanPartyProfileStatementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanPartyProfileStatement> validator() {
		return new AbstractLoanPartyProfileStatementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanPartyProfileStatement> typeFormatValidator() {
		return new AbstractLoanPartyProfileStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanPartyProfileStatement, Set<String>> onlyExistsValidator() {
		return new AbstractLoanPartyProfileStatementOnlyExistsValidator();
	}
}
