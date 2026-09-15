package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingCostOfCarry;
import fpml.consolidated.loan.validation.LoanTradingCostOfCarryTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradingCostOfCarryValidator;
import fpml.consolidated.loan.validation.exists.LoanTradingCostOfCarryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradingCostOfCarry.class)
public class LoanTradingCostOfCarryMeta implements RosettaMetaData<LoanTradingCostOfCarry> {

	@Override
	public List<Validator<? super LoanTradingCostOfCarry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCostOfCarry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradingCostOfCarry> validator(ValidatorFactory factory) {
		return factory.<LoanTradingCostOfCarry>create(LoanTradingCostOfCarryValidator.class);
	}

	@Override
	public Validator<? super LoanTradingCostOfCarry> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradingCostOfCarry>create(LoanTradingCostOfCarryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingCostOfCarry> validator() {
		return new LoanTradingCostOfCarryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingCostOfCarry> typeFormatValidator() {
		return new LoanTradingCostOfCarryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCostOfCarry, Set<String>> onlyExistsValidator() {
		return new LoanTradingCostOfCarryOnlyExistsValidator();
	}
}
