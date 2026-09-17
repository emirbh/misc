package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CustodianTerms;
import cdm.legaldocumentation.csa.EligibilityToHoldCollateral;
import cdm.legaldocumentation.csa.HoldingPostedCollateralEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EligibilityToHoldCollateralOnlyExistsValidator implements ValidatorWithArg<EligibilityToHoldCollateral, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EligibilityToHoldCollateral> ValidationResult<EligibilityToHoldCollateral> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyTerms", ExistenceChecker.isSet((List<HoldingPostedCollateralEnum>) o.getPartyTerms()))
				.put("custodianTerms", ExistenceChecker.isSet((CustodianTerms) o.getCustodianTerms()))
				.put("eligibleCountry", ExistenceChecker.isSet((List<? extends FieldWithMetaString>) o.getEligibleCountry()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EligibilityToHoldCollateral", ValidationResult.ValidationType.ONLY_EXISTS, "EligibilityToHoldCollateral", path, "");
		}
		return failure("EligibilityToHoldCollateral", ValidationResult.ValidationType.ONLY_EXISTS, "EligibilityToHoldCollateral", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
