package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbINDP;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbINDPOnlyExistsValidator implements ValidatorWithArg<AnnaDsbINDP, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbINDP> ValidationResult<AnnaDsbINDP> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("CSTR", ExistenceChecker.isSet((AnnaDsbEmpty) o.getCSTR()))
				.put("MFTG", ExistenceChecker.isSet((AnnaDsbEmpty) o.getMFTG()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbINDP", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbINDP", path, "");
		}
		return failure("AnnaDsbINDP", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbINDP", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
