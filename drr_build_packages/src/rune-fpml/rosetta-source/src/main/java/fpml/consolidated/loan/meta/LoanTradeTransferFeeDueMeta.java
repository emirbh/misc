package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeTransferFeeDue;
import fpml.consolidated.loan.validation.LoanTradeTransferFeeDueTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeTransferFeeDueValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeTransferFeeDueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeTransferFeeDue.class)
public class LoanTradeTransferFeeDueMeta implements RosettaMetaData<LoanTradeTransferFeeDue> {

	@Override
	public List<Validator<? super LoanTradeTransferFeeDue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeTransferFeeDue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeTransferFeeDue> validator(ValidatorFactory factory) {
		return factory.<LoanTradeTransferFeeDue>create(LoanTradeTransferFeeDueValidator.class);
	}

	@Override
	public Validator<? super LoanTradeTransferFeeDue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeTransferFeeDue>create(LoanTradeTransferFeeDueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeTransferFeeDue> validator() {
		return new LoanTradeTransferFeeDueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeTransferFeeDue> typeFormatValidator() {
		return new LoanTradeTransferFeeDueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeTransferFeeDue, Set<String>> onlyExistsValidator() {
		return new LoanTradeTransferFeeDueOnlyExistsValidator();
	}
}
