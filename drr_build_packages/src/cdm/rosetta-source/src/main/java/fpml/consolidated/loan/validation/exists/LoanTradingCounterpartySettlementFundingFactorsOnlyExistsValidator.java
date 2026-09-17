package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.BuyerSellerAmounts;
import fpml.consolidated.loan.LoanTradingCostOfCarry;
import fpml.consolidated.loan.LoanTradingCounterpartySettlementFundingFactors;
import fpml.consolidated.loan.LoanTradingDelayedCompensation;
import fpml.consolidated.loan.LoanTradingEconomicBenefit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingCounterpartySettlementFundingFactorsOnlyExistsValidator implements ValidatorWithArg<LoanTradingCounterpartySettlementFundingFactors, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingCounterpartySettlementFundingFactors> ValidationResult<LoanTradingCounterpartySettlementFundingFactors> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("delayedCompensation", ExistenceChecker.isSet((LoanTradingDelayedCompensation) o.getDelayedCompensation()))
				.put("costOfCarry", ExistenceChecker.isSet((LoanTradingCostOfCarry) o.getCostOfCarry()))
				.put("economicBenefit", ExistenceChecker.isSet((List<? extends LoanTradingEconomicBenefit>) o.getEconomicBenefit()))
				.put("transferFeeAmounts", ExistenceChecker.isSet((BuyerSellerAmounts) o.getTransferFeeAmounts()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingCounterpartySettlementFundingFactors", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingCounterpartySettlementFundingFactors", path, "");
		}
		return failure("LoanTradingCounterpartySettlementFundingFactors", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingCounterpartySettlementFundingFactors", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
