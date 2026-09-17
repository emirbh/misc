package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
import cdm.observable.asset.SettlementRateOption;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonDeliverableSubstituteOnlyExistsValidator implements ValidatorWithArg<NonDeliverableSubstitute, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonDeliverableSubstitute> ValidationResult<NonDeliverableSubstitute> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("nonDeliverableSubstituteIsApplicable", ExistenceChecker.isSet((Boolean) o.getNonDeliverableSubstituteIsApplicable()))
				.put("valuationDate", ExistenceChecker.isSet((AdjustedRelativeDateOffset) o.getValuationDate()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustedRelativeDateOffset) o.getSettlementDate()))
				.put("settlementRateOption", ExistenceChecker.isSet((SettlementRateOption) o.getSettlementRateOption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonDeliverableSubstitute", ValidationResult.ValidationType.ONLY_EXISTS, "NonDeliverableSubstitute", path, "");
		}
		return failure("NonDeliverableSubstitute", ValidationResult.ValidationType.ONLY_EXISTS, "NonDeliverableSubstitute", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
