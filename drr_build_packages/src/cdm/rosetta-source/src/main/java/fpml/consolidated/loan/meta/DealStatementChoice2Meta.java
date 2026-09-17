package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealStatementChoice2;
import fpml.consolidated.loan.validation.DealStatementChoice2TypeFormatValidator;
import fpml.consolidated.loan.validation.DealStatementChoice2Validator;
import fpml.consolidated.loan.validation.datarule.DealStatementChoice2Choice;
import fpml.consolidated.loan.validation.exists.DealStatementChoice2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DealStatementChoice2.class)
public class DealStatementChoice2Meta implements RosettaMetaData<DealStatementChoice2> {

	@Override
	public List<Validator<? super DealStatementChoice2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DealStatementChoice2>create(DealStatementChoice2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super DealStatementChoice2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DealStatementChoice2> validator(ValidatorFactory factory) {
		return factory.<DealStatementChoice2>create(DealStatementChoice2Validator.class);
	}

	@Override
	public Validator<? super DealStatementChoice2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DealStatementChoice2>create(DealStatementChoice2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DealStatementChoice2> validator() {
		return new DealStatementChoice2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DealStatementChoice2> typeFormatValidator() {
		return new DealStatementChoice2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealStatementChoice2, Set<String>> onlyExistsValidator() {
		return new DealStatementChoice2OnlyExistsValidator();
	}
}
