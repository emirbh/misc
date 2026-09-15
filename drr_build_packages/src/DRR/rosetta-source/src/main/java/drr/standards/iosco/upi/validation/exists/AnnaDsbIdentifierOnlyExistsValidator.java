package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbIdentifier;
import drr.standards.iosco.upi.AnnaDsbStatusEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbIdentifierOnlyExistsValidator implements ValidatorWithArg<AnnaDsbIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbIdentifier> ValidationResult<AnnaDsbIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("Status", ExistenceChecker.isSet((AnnaDsbStatusEnum) o.getStatus()))
				.put("LastUpdateDateTime", ExistenceChecker.isSet((String) o.getLastUpdateDateTime()))
				.put("StatusReason", ExistenceChecker.isSet((String) o.getStatusReason()))
				.put("UPI", ExistenceChecker.isSet((String) o.getUPI()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbIdentifier", path, "");
		}
		return failure("AnnaDsbIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
