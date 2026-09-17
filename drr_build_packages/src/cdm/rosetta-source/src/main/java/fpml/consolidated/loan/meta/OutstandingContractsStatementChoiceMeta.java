package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.OutstandingContractsStatementChoice;
import fpml.consolidated.loan.validation.OutstandingContractsStatementChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.OutstandingContractsStatementChoiceValidator;
import fpml.consolidated.loan.validation.datarule.OutstandingContractsStatementChoiceChoice;
import fpml.consolidated.loan.validation.exists.OutstandingContractsStatementChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OutstandingContractsStatementChoice.class)
public class OutstandingContractsStatementChoiceMeta implements RosettaMetaData<OutstandingContractsStatementChoice> {

	@Override
	public List<Validator<? super OutstandingContractsStatementChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OutstandingContractsStatementChoice>create(OutstandingContractsStatementChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OutstandingContractsStatementChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OutstandingContractsStatementChoice> validator(ValidatorFactory factory) {
		return factory.<OutstandingContractsStatementChoice>create(OutstandingContractsStatementChoiceValidator.class);
	}

	@Override
	public Validator<? super OutstandingContractsStatementChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OutstandingContractsStatementChoice>create(OutstandingContractsStatementChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OutstandingContractsStatementChoice> validator() {
		return new OutstandingContractsStatementChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OutstandingContractsStatementChoice> typeFormatValidator() {
		return new OutstandingContractsStatementChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OutstandingContractsStatementChoice, Set<String>> onlyExistsValidator() {
		return new OutstandingContractsStatementChoiceOnlyExistsValidator();
	}
}
