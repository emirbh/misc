package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingDelayedCompensation;
import fpml.consolidated.loan.LoanTradingFacilityFeeAccrual;
import fpml.consolidated.loan.LoanTradingLetterOfCreditAccrual;
import fpml.consolidated.loan.LoanTradingLoanContractAccrual;
import fpml.consolidated.loan.LoanTradingNonAccruingFee;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingDelayedCompensationOnlyExistsValidator implements ValidatorWithArg<LoanTradingDelayedCompensation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingDelayedCompensation> ValidationResult<LoanTradingDelayedCompensation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("facilityAccrual", ExistenceChecker.isSet((List<? extends LoanTradingFacilityFeeAccrual>) o.getFacilityAccrual()))
				.put("loanContractInterestAccrual", ExistenceChecker.isSet((List<? extends LoanTradingLoanContractAccrual>) o.getLoanContractInterestAccrual()))
				.put("letterOfCreditAccrual", ExistenceChecker.isSet((List<? extends LoanTradingLetterOfCreditAccrual>) o.getLetterOfCreditAccrual()))
				.put("nonAccruingFee", ExistenceChecker.isSet((List<? extends LoanTradingNonAccruingFee>) o.getNonAccruingFee()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingDelayedCompensation", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingDelayedCompensation", path, "");
		}
		return failure("LoanTradingDelayedCompensation", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingDelayedCompensation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
