package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeSettlementTask;
import fpml.consolidated.loan.validation.LoanTradeSettlementTaskTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeSettlementTaskValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeSettlementTaskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeSettlementTask.class)
public class LoanTradeSettlementTaskMeta implements RosettaMetaData<LoanTradeSettlementTask> {

	@Override
	public List<Validator<? super LoanTradeSettlementTask>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeSettlementTask, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeSettlementTask> validator(ValidatorFactory factory) {
		return factory.<LoanTradeSettlementTask>create(LoanTradeSettlementTaskValidator.class);
	}

	@Override
	public Validator<? super LoanTradeSettlementTask> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeSettlementTask>create(LoanTradeSettlementTaskTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeSettlementTask> validator() {
		return new LoanTradeSettlementTaskValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeSettlementTask> typeFormatValidator() {
		return new LoanTradeSettlementTaskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeSettlementTask, Set<String>> onlyExistsValidator() {
		return new LoanTradeSettlementTaskOnlyExistsValidator();
	}
}
