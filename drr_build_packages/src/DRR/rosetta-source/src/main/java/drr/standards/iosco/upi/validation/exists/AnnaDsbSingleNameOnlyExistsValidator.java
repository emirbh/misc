package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbSingleName;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbSingleNameOnlyExistsValidator implements ValidatorWithArg<AnnaDsbSingleName, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbSingleName> ValidationResult<AnnaDsbSingleName> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("UnderlierIDSource", ExistenceChecker.isSet((AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource()))
				.put("DebtSeniority", ExistenceChecker.isSet((AnnaDsbDebtSeniorityEnum) o.getDebtSeniority()))
				.put("UnderlierID", ExistenceChecker.isSet((String) o.getUnderlierID()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbSingleName", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbSingleName", path, "");
		}
		return failure("AnnaDsbSingleName", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbSingleName", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
