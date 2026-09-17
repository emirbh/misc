package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.CommitmentAdjustment;
import fpml.consolidated.loan.LoanTradingEconomicBenefit;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingEconomicBenefitOnlyExistsValidator implements ValidatorWithArg<LoanTradingEconomicBenefit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingEconomicBenefit> ValidationResult<LoanTradingEconomicBenefit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("eventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getEventIdentifier()))
				.put("commitmentAdjustment", ExistenceChecker.isSet((CommitmentAdjustment) o.getCommitmentAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingEconomicBenefit", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingEconomicBenefit", path, "");
		}
		return failure("LoanTradingEconomicBenefit", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradingEconomicBenefit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
