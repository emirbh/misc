package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReplacementValueCalculationAgentDeterminationMethodOnlyExistsValidator implements ValidatorWithArg<ReplacementValueCalculationAgentDeterminationMethod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReplacementValueCalculationAgentDeterminationMethod> ValidationResult<ReplacementValueCalculationAgentDeterminationMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashSettlementCurrency", ExistenceChecker.isSet((Currency) o.getCashSettlementCurrency()))
				.put("cashSettlementReferenceBanks", ExistenceChecker.isSet((CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks()))
				.put("protectedParty", ExistenceChecker.isSet((PartySelector) o.getProtectedParty()))
				.put("cashCollateralCurrency", ExistenceChecker.isSet((Currency) o.getCashCollateralCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReplacementValueCalculationAgentDeterminationMethod", ValidationResult.ValidationType.ONLY_EXISTS, "ReplacementValueCalculationAgentDeterminationMethod", path, "");
		}
		return failure("ReplacementValueCalculationAgentDeterminationMethod", ValidationResult.ValidationType.ONLY_EXISTS, "ReplacementValueCalculationAgentDeterminationMethod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
