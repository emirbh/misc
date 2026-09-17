package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Routing;
import fpml.consolidated.shared.SplitSettlement;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SplitSettlementOnlyExistsValidator implements ValidatorWithArg<SplitSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SplitSettlement> ValidationResult<SplitSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("splitSettlementAmount", ExistenceChecker.isSet((Money) o.getSplitSettlementAmount()))
				.put("beneficiaryBank", ExistenceChecker.isSet((Routing) o.getBeneficiaryBank()))
				.put("beneficiary", ExistenceChecker.isSet((Routing) o.getBeneficiary()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SplitSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "SplitSettlement", path, "");
		}
		return failure("SplitSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "SplitSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
