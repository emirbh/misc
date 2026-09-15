package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BrokerConfirmation;
import fpml.consolidated.shared.BrokerConfirmationType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BrokerConfirmationOnlyExistsValidator implements ValidatorWithArg<BrokerConfirmation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BrokerConfirmation> ValidationResult<BrokerConfirmation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("brokerConfirmationType", ExistenceChecker.isSet((BrokerConfirmationType) o.getBrokerConfirmationType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BrokerConfirmation", ValidationResult.ValidationType.ONLY_EXISTS, "BrokerConfirmation", path, "");
		}
		return failure("BrokerConfirmation", ValidationResult.ValidationType.ONLY_EXISTS, "BrokerConfirmation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
