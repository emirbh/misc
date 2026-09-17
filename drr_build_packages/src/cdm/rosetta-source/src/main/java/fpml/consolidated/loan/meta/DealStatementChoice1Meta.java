package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealStatementChoice1;
import fpml.consolidated.loan.validation.DealStatementChoice1TypeFormatValidator;
import fpml.consolidated.loan.validation.DealStatementChoice1Validator;
import fpml.consolidated.loan.validation.datarule.DealStatementChoice1Choice;
import fpml.consolidated.loan.validation.exists.DealStatementChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DealStatementChoice1.class)
public class DealStatementChoice1Meta implements RosettaMetaData<DealStatementChoice1> {

	@Override
	public List<Validator<? super DealStatementChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DealStatementChoice1>create(DealStatementChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super DealStatementChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DealStatementChoice1> validator(ValidatorFactory factory) {
		return factory.<DealStatementChoice1>create(DealStatementChoice1Validator.class);
	}

	@Override
	public Validator<? super DealStatementChoice1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DealStatementChoice1>create(DealStatementChoice1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DealStatementChoice1> validator() {
		return new DealStatementChoice1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DealStatementChoice1> typeFormatValidator() {
		return new DealStatementChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealStatementChoice1, Set<String>> onlyExistsValidator() {
		return new DealStatementChoice1OnlyExistsValidator();
	}
}
