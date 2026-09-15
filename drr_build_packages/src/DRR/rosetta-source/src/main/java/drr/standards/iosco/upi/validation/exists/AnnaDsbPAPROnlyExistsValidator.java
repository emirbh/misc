package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbPAPR;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbPAPROnlyExistsValidator implements ValidatorWithArg<AnnaDsbPAPR, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbPAPR> ValidationResult<AnnaDsbPAPR> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("PULP", ExistenceChecker.isSet((AnnaDsbEmpty) o.getPULP()))
				.put("NSPT", ExistenceChecker.isSet((AnnaDsbEmpty) o.getNSPT()))
				.put("RCVP", ExistenceChecker.isSet((AnnaDsbEmpty) o.getRCVP()))
				.put("CBRD", ExistenceChecker.isSet((AnnaDsbEmpty) o.getCBRD()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbPAPR", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbPAPR", path, "");
		}
		return failure("AnnaDsbPAPR", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbPAPR", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
