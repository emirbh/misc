package drr.enrichment.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.enrichment.upi.AnnaDsbUpiRequestTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUpiRequestAndTypeOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUpiRequestAndType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUpiRequestAndType> ValidationResult<AnnaDsbUpiRequestAndType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("request", ExistenceChecker.isSet((AnnaDsbUpiRequest) o.getRequest()))
				.put("requestType", ExistenceChecker.isSet((AnnaDsbUpiRequestTypeEnum) o.getRequestType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUpiRequestAndType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUpiRequestAndType", path, "");
		}
		return failure("AnnaDsbUpiRequestAndType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUpiRequestAndType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
