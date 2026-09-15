package drr.regulation.common.validation.exists;

import cdm.base.staticdata.party.Address;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ExecutingEntity;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExecutingEntityOnlyExistsValidator implements ValidatorWithArg<ExecutingEntity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExecutingEntity> ValidationResult<ExecutingEntity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isInvestmentFirm", ExistenceChecker.isSet((Boolean) o.getIsInvestmentFirm()))
				.put("addressOfBranch", ExistenceChecker.isSet((Address) o.getAddressOfBranch()))
				.put("addressOfIncorporation", ExistenceChecker.isSet((Address) o.getAddressOfIncorporation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExecutingEntity", ValidationResult.ValidationType.ONLY_EXISTS, "ExecutingEntity", path, "");
		}
		return failure("ExecutingEntity", ValidationResult.ValidationType.ONLY_EXISTS, "ExecutingEntity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
