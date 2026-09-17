package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.datetime.BusinessCenterTime;
import cdm.legaldocumentation.csa.DisputeResolution;
import cdm.legaldocumentation.csa.LegacyResolutionAlternative;
import cdm.legaldocumentation.csa.LegacyResolutionValue;
import cdm.legaldocumentation.csa.RecalculationOfValue;
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

public class DisputeResolutionOnlyExistsValidator implements ValidatorWithArg<DisputeResolution, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DisputeResolution> ValidationResult<DisputeResolution> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("resolutionTime", ExistenceChecker.isSet((BusinessCenterTime) o.getResolutionTime()))
				.put("otherTerms", ExistenceChecker.isSet((String) o.getOtherTerms()))
				.put("valueTerms", ExistenceChecker.isSet((String) o.getValueTerms()))
				.put("alternativeTerms", ExistenceChecker.isSet((String) o.getAlternativeTerms()))
				.put("recalculationOfValue", ExistenceChecker.isSet((RecalculationOfValue) o.getRecalculationOfValue()))
				.put("legacyResolutionTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLegacyResolutionTime()))
				.put("legacyAlternative", ExistenceChecker.isSet((LegacyResolutionAlternative) o.getLegacyAlternative()))
				.put("legacyValue", ExistenceChecker.isSet((LegacyResolutionValue) o.getLegacyValue()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DisputeResolution", ValidationResult.ValidationType.ONLY_EXISTS, "DisputeResolution", path, "");
		}
		return failure("DisputeResolution", ValidationResult.ValidationType.ONLY_EXISTS, "DisputeResolution", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
