package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.ElectiveAmountElection;
import cdm.legaldocumentation.csa.MinimumTransferAmount;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MinimumTransferAmountOnlyExistsValidator implements ValidatorWithArg<MinimumTransferAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MinimumTransferAmount> ValidationResult<MinimumTransferAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyElection", ExistenceChecker.isSet((List<? extends ElectiveAmountElection>) o.getPartyElection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MinimumTransferAmount", ValidationResult.ValidationType.ONLY_EXISTS, "MinimumTransferAmount", path, "");
		}
		return failure("MinimumTransferAmount", ValidationResult.ValidationType.ONLY_EXISTS, "MinimumTransferAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
