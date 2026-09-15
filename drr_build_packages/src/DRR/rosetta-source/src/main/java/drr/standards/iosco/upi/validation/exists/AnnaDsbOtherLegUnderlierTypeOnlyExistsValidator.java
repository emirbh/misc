package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbOtherLegUnderlierTypeOnlyExistsValidator implements ValidatorWithArg<AnnaDsbOtherLegUnderlierType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbOtherLegUnderlierType> ValidationResult<AnnaDsbOtherLegUnderlierType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("OtherLegUnderlierID", ExistenceChecker.isSet((String) o.getOtherLegUnderlierID()))
				.put("OtherLegUnderlierIDSource", ExistenceChecker.isSet((AnnaDsbOtherLegUnderlierIDSourceEnum) o.getOtherLegUnderlierIDSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbOtherLegUnderlierType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbOtherLegUnderlierType", path, "");
		}
		return failure("AnnaDsbOtherLegUnderlierType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbOtherLegUnderlierType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
