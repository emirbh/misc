package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingCostOfCarryAccrual;
import fpml.consolidated.loan.validation.LoanTradingCostOfCarryAccrualTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradingCostOfCarryAccrualValidator;
import fpml.consolidated.loan.validation.datarule.LoanTradingCostOfCarryAccrualChoice;
import fpml.consolidated.loan.validation.exists.LoanTradingCostOfCarryAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradingCostOfCarryAccrual.class)
public class LoanTradingCostOfCarryAccrualMeta implements RosettaMetaData<LoanTradingCostOfCarryAccrual> {

	@Override
	public List<Validator<? super LoanTradingCostOfCarryAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanTradingCostOfCarryAccrual>create(LoanTradingCostOfCarryAccrualChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCostOfCarryAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradingCostOfCarryAccrual> validator(ValidatorFactory factory) {
		return factory.<LoanTradingCostOfCarryAccrual>create(LoanTradingCostOfCarryAccrualValidator.class);
	}

	@Override
	public Validator<? super LoanTradingCostOfCarryAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradingCostOfCarryAccrual>create(LoanTradingCostOfCarryAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingCostOfCarryAccrual> validator() {
		return new LoanTradingCostOfCarryAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingCostOfCarryAccrual> typeFormatValidator() {
		return new LoanTradingCostOfCarryAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCostOfCarryAccrual, Set<String>> onlyExistsValidator() {
		return new LoanTradingCostOfCarryAccrualOnlyExistsValidator();
	}
}
