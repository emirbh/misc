package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.RegulatoryRegimeEnum;
import cdm.legaldocumentation.csa.SubstitutedRegime;
import cdm.legaldocumentation.csa.SubstitutedRegimeTerms;
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

public class SubstitutedRegimeOnlyExistsValidator implements ValidatorWithArg<SubstitutedRegime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SubstitutedRegime> ValidationResult<SubstitutedRegime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("regime", ExistenceChecker.isSet((RegulatoryRegimeEnum) o.getRegime()))
				.put("additionalRegime", ExistenceChecker.isSet((String) o.getAdditionalRegime()))
				.put("regimeTerms", ExistenceChecker.isSet((List<? extends SubstitutedRegimeTerms>) o.getRegimeTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SubstitutedRegime", ValidationResult.ValidationType.ONLY_EXISTS, "SubstitutedRegime", path, "");
		}
		return failure("SubstitutedRegime", ValidationResult.ValidationType.ONLY_EXISTS, "SubstitutedRegime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
