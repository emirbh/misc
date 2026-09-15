package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeTransferFeeOwed;
import fpml.consolidated.loan.validation.LoanTradeTransferFeeOwedTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeTransferFeeOwedValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeTransferFeeOwedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeTransferFeeOwed.class)
public class LoanTradeTransferFeeOwedMeta implements RosettaMetaData<LoanTradeTransferFeeOwed> {

	@Override
	public List<Validator<? super LoanTradeTransferFeeOwed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeTransferFeeOwed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeTransferFeeOwed> validator(ValidatorFactory factory) {
		return factory.<LoanTradeTransferFeeOwed>create(LoanTradeTransferFeeOwedValidator.class);
	}

	@Override
	public Validator<? super LoanTradeTransferFeeOwed> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeTransferFeeOwed>create(LoanTradeTransferFeeOwedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeTransferFeeOwed> validator() {
		return new LoanTradeTransferFeeOwedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeTransferFeeOwed> typeFormatValidator() {
		return new LoanTradeTransferFeeOwedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeTransferFeeOwed, Set<String>> onlyExistsValidator() {
		return new LoanTradeTransferFeeOwedOnlyExistsValidator();
	}
}
