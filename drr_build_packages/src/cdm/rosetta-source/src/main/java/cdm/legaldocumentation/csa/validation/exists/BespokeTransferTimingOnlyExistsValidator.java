package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.BespokeTransferTiming;
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

public class BespokeTransferTimingOnlyExistsValidator implements ValidatorWithArg<BespokeTransferTiming, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BespokeTransferTiming> ValidationResult<BespokeTransferTiming> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isApplicable", ExistenceChecker.isSet((Boolean) o.getIsApplicable()))
				.put("bespokeTransferTimingTerms", ExistenceChecker.isSet((String) o.getBespokeTransferTimingTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BespokeTransferTiming", ValidationResult.ValidationType.ONLY_EXISTS, "BespokeTransferTiming", path, "");
		}
		return failure("BespokeTransferTiming", ValidationResult.ValidationType.ONLY_EXISTS, "BespokeTransferTiming", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
