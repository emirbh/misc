package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealStatement;
import fpml.consolidated.loan.validation.DealStatementTypeFormatValidator;
import fpml.consolidated.loan.validation.DealStatementValidator;
import fpml.consolidated.loan.validation.exists.DealStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DealStatement.class)
public class DealStatementMeta implements RosettaMetaData<DealStatement> {

	@Override
	public List<Validator<? super DealStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DealStatement> validator(ValidatorFactory factory) {
		return factory.<DealStatement>create(DealStatementValidator.class);
	}

	@Override
	public Validator<? super DealStatement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DealStatement>create(DealStatementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DealStatement> validator() {
		return new DealStatementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DealStatement> typeFormatValidator() {
		return new DealStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealStatement, Set<String>> onlyExistsValidator() {
		return new DealStatementOnlyExistsValidator();
	}
}
