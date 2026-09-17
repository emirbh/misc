package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.PriceMateriality;
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

public class PriceMaterialityOnlyExistsValidator implements ValidatorWithArg<PriceMateriality, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PriceMateriality> ValidationResult<PriceMateriality> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("priceMaterialityIsApplicable", ExistenceChecker.isSet((Boolean) o.getPriceMaterialityIsApplicable()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.put("fallbackReferencePrice", ExistenceChecker.isSet((SettlementRateOption) o.getFallbackReferencePrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PriceMateriality", ValidationResult.ValidationType.ONLY_EXISTS, "PriceMateriality", path, "");
		}
		return failure("PriceMateriality", ValidationResult.ValidationType.ONLY_EXISTS, "PriceMateriality", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
