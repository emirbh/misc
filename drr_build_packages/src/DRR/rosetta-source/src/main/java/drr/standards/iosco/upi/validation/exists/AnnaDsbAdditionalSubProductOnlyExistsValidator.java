package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProductEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbAdditionalSubProductOnlyExistsValidator implements ValidatorWithArg<AnnaDsbAdditionalSubProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbAdditionalSubProduct> ValidationResult<AnnaDsbAdditionalSubProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("AdditionalSubProduct", ExistenceChecker.isSet((AnnaDsbAdditionalSubProductEnum) o.getAdditionalSubProduct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbAdditionalSubProduct", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbAdditionalSubProduct", path, "");
		}
		return failure("AnnaDsbAdditionalSubProduct", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbAdditionalSubProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
