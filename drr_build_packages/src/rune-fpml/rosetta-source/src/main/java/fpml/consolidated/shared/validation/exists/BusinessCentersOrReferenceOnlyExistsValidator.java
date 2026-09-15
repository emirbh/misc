package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersOrReference;
import fpml.consolidated.shared.BusinessCentersReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BusinessCentersOrReferenceOnlyExistsValidator implements ValidatorWithArg<BusinessCentersOrReference, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BusinessCentersOrReference> ValidationResult<BusinessCentersOrReference> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("businessCentersReference", ExistenceChecker.isSet((BusinessCentersReference) o.getBusinessCentersReference()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BusinessCentersOrReference", ValidationResult.ValidationType.ONLY_EXISTS, "BusinessCentersOrReference", path, "");
		}
		return failure("BusinessCentersOrReference", ValidationResult.ValidationType.ONLY_EXISTS, "BusinessCentersOrReference", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
