package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealStatementChoice0;
import fpml.consolidated.loan.validation.DealStatementChoice0TypeFormatValidator;
import fpml.consolidated.loan.validation.DealStatementChoice0Validator;
import fpml.consolidated.loan.validation.datarule.DealStatementChoice0Choice;
import fpml.consolidated.loan.validation.exists.DealStatementChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DealStatementChoice0.class)
public class DealStatementChoice0Meta implements RosettaMetaData<DealStatementChoice0> {

	@Override
	public List<Validator<? super DealStatementChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DealStatementChoice0>create(DealStatementChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super DealStatementChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DealStatementChoice0> validator(ValidatorFactory factory) {
		return factory.<DealStatementChoice0>create(DealStatementChoice0Validator.class);
	}

	@Override
	public Validator<? super DealStatementChoice0> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DealStatementChoice0>create(DealStatementChoice0TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DealStatementChoice0> validator() {
		return new DealStatementChoice0Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DealStatementChoice0> typeFormatValidator() {
		return new DealStatementChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealStatementChoice0, Set<String>> onlyExistsValidator() {
		return new DealStatementChoice0OnlyExistsValidator();
	}
}
