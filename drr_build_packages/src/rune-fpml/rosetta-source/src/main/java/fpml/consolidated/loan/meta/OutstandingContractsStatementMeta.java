package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.OutstandingContractsStatement;
import fpml.consolidated.loan.validation.OutstandingContractsStatementTypeFormatValidator;
import fpml.consolidated.loan.validation.OutstandingContractsStatementValidator;
import fpml.consolidated.loan.validation.datarule.OutstandingContractsStatementChoice;
import fpml.consolidated.loan.validation.exists.OutstandingContractsStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OutstandingContractsStatement.class)
public class OutstandingContractsStatementMeta implements RosettaMetaData<OutstandingContractsStatement> {

	@Override
	public List<Validator<? super OutstandingContractsStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OutstandingContractsStatement>create(OutstandingContractsStatementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OutstandingContractsStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OutstandingContractsStatement> validator(ValidatorFactory factory) {
		return factory.<OutstandingContractsStatement>create(OutstandingContractsStatementValidator.class);
	}

	@Override
	public Validator<? super OutstandingContractsStatement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OutstandingContractsStatement>create(OutstandingContractsStatementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OutstandingContractsStatement> validator() {
		return new OutstandingContractsStatementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OutstandingContractsStatement> typeFormatValidator() {
		return new OutstandingContractsStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OutstandingContractsStatement, Set<String>> onlyExistsValidator() {
		return new OutstandingContractsStatementOnlyExistsValidator();
	}
}
