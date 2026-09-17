package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.AdditionalTypeEnum;
import cdm.legaldocumentation.csa.ApplicableRegime;
import cdm.legaldocumentation.csa.RegimeTerms;
import cdm.legaldocumentation.csa.RegulatoryRegimeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApplicableRegimeOnlyExistsValidator implements ValidatorWithArg<ApplicableRegime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApplicableRegime> ValidationResult<ApplicableRegime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("regime", ExistenceChecker.isSet((RegulatoryRegimeEnum) o.getRegime()))
				.put("additionalRegime", ExistenceChecker.isSet((String) o.getAdditionalRegime()))
				.put("regimeTerms", ExistenceChecker.isSet((List<? extends RegimeTerms>) o.getRegimeTerms()))
				.put("additionalType", ExistenceChecker.isSet((AdditionalTypeEnum) o.getAdditionalType()))
				.put("additionalTerms", ExistenceChecker.isSet((String) o.getAdditionalTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApplicableRegime", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableRegime", path, "");
		}
		return failure("ApplicableRegime", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableRegime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
