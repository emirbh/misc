package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbContractSpecification;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUnderlyingIssuerTypeOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUnderlyingIssuerType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUnderlyingIssuerType> ValidationResult<AnnaDsbUnderlyingIssuerType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("Sovereign", ExistenceChecker.isSet((AnnaDsbContractSpecification) o.getSovereign()))
				.put("Corporate", ExistenceChecker.isSet((AnnaDsbContractSpecification) o.getCorporate()))
				.put("Local", ExistenceChecker.isSet((AnnaDsbContractSpecification) o.getLocal()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUnderlyingIssuerType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlyingIssuerType", path, "");
		}
		return failure("AnnaDsbUnderlyingIssuerType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlyingIssuerType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
