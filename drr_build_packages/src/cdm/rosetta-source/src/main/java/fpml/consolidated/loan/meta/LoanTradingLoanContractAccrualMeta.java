package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingLoanContractAccrual;
import fpml.consolidated.loan.validation.LoanTradingLoanContractAccrualTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradingLoanContractAccrualValidator;
import fpml.consolidated.loan.validation.exists.LoanTradingLoanContractAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradingLoanContractAccrual.class)
public class LoanTradingLoanContractAccrualMeta implements RosettaMetaData<LoanTradingLoanContractAccrual> {

	@Override
	public List<Validator<? super LoanTradingLoanContractAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingLoanContractAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradingLoanContractAccrual> validator(ValidatorFactory factory) {
		return factory.<LoanTradingLoanContractAccrual>create(LoanTradingLoanContractAccrualValidator.class);
	}

	@Override
	public Validator<? super LoanTradingLoanContractAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradingLoanContractAccrual>create(LoanTradingLoanContractAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingLoanContractAccrual> validator() {
		return new LoanTradingLoanContractAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingLoanContractAccrual> typeFormatValidator() {
		return new LoanTradingLoanContractAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingLoanContractAccrual, Set<String>> onlyExistsValidator() {
		return new LoanTradingLoanContractAccrualOnlyExistsValidator();
	}
}
