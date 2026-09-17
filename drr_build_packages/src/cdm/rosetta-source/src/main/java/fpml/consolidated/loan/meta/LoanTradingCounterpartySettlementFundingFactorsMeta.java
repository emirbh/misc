package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingCounterpartySettlementFundingFactors;
import fpml.consolidated.loan.validation.LoanTradingCounterpartySettlementFundingFactorsTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradingCounterpartySettlementFundingFactorsValidator;
import fpml.consolidated.loan.validation.exists.LoanTradingCounterpartySettlementFundingFactorsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradingCounterpartySettlementFundingFactors.class)
public class LoanTradingCounterpartySettlementFundingFactorsMeta implements RosettaMetaData<LoanTradingCounterpartySettlementFundingFactors> {

	@Override
	public List<Validator<? super LoanTradingCounterpartySettlementFundingFactors>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingCounterpartySettlementFundingFactors, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactors> validator(ValidatorFactory factory) {
		return factory.<LoanTradingCounterpartySettlementFundingFactors>create(LoanTradingCounterpartySettlementFundingFactorsValidator.class);
	}

	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactors> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradingCounterpartySettlementFundingFactors>create(LoanTradingCounterpartySettlementFundingFactorsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactors> validator() {
		return new LoanTradingCounterpartySettlementFundingFactorsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingCounterpartySettlementFundingFactors> typeFormatValidator() {
		return new LoanTradingCounterpartySettlementFundingFactorsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingCounterpartySettlementFundingFactors, Set<String>> onlyExistsValidator() {
		return new LoanTradingCounterpartySettlementFundingFactorsOnlyExistsValidator();
	}
}
