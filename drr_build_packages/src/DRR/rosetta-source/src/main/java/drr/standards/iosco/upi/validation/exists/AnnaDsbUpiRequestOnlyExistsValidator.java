package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAttributes;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUpiRequestOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUpiRequest, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUpiRequest> ValidationResult<AnnaDsbUpiRequest> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("Header", ExistenceChecker.isSet((AnnaDsbHeader) o.getHeader()))
				.put("Attributes", ExistenceChecker.isSet((AnnaDsbAttributes) o.getAttributes()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUpiRequest", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUpiRequest", path, "");
		}
		return failure("AnnaDsbUpiRequest", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUpiRequest", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
