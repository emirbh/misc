package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationSettlementTask;
import fpml.consolidated.loan.validation.LoanAllocationSettlementTaskTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationSettlementTaskValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationSettlementTaskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationSettlementTask.class)
public class LoanAllocationSettlementTaskMeta implements RosettaMetaData<LoanAllocationSettlementTask> {

	@Override
	public List<Validator<? super LoanAllocationSettlementTask>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementTask, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationSettlementTask> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlementTask>create(LoanAllocationSettlementTaskValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationSettlementTask> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationSettlementTask>create(LoanAllocationSettlementTaskTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlementTask> validator() {
		return new LoanAllocationSettlementTaskValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationSettlementTask> typeFormatValidator() {
		return new LoanAllocationSettlementTaskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementTask, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementTaskOnlyExistsValidator();
	}
}
