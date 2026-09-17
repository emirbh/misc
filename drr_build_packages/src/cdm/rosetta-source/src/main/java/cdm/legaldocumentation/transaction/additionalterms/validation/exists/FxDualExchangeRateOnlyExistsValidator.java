package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxDualExchangeRate;
import cdm.observable.asset.FallbackReferencePrice;
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

public class FxDualExchangeRateOnlyExistsValidator implements ValidatorWithArg<FxDualExchangeRate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxDualExchangeRate> ValidationResult<FxDualExchangeRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dualExchangeRateIsApplicable", ExistenceChecker.isSet((Boolean) o.getDualExchangeRateIsApplicable()))
				.put("fallbackReferencePrice", ExistenceChecker.isSet((FallbackReferencePrice) o.getFallbackReferencePrice()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxDualExchangeRate", ValidationResult.ValidationType.ONLY_EXISTS, "FxDualExchangeRate", path, "");
		}
		return failure("FxDualExchangeRate", ValidationResult.ValidationType.ONLY_EXISTS, "FxDualExchangeRate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
