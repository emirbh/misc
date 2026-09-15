package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbFRTL;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbFRTLOnlyExistsValidator implements ValidatorWithArg<AnnaDsbFRTL, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbFRTL> ValidationResult<AnnaDsbFRTL> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("AMMO", ExistenceChecker.isSet((AnnaDsbEmpty) o.getAMMO()))
				.put("SLPH", ExistenceChecker.isSet((AnnaDsbEmpty) o.getSLPH()))
				.put("DAPH", ExistenceChecker.isSet((AnnaDsbEmpty) o.getDAPH()))
				.put("PTSH", ExistenceChecker.isSet((AnnaDsbEmpty) o.getPTSH()))
				.put("UREA", ExistenceChecker.isSet((AnnaDsbEmpty) o.getUREA()))
				.put("UAAN", ExistenceChecker.isSet((AnnaDsbEmpty) o.getUAAN()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbFRTL", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbFRTL", path, "");
		}
		return failure("AnnaDsbFRTL", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbFRTL", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
