package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.ExercisePeriod;
import fpml.consolidated.ird.MandatoryEarlyTermination;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.shared.Period;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EarlyTerminationProvisionOnlyExistsValidator implements ValidatorWithArg<EarlyTerminationProvision, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EarlyTerminationProvision> ValidationResult<EarlyTerminationProvision> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("mandatoryEarlyTermination", ExistenceChecker.isSet((MandatoryEarlyTermination) o.getMandatoryEarlyTermination()))
				.put("mandatoryEarlyTerminationDateTenor", ExistenceChecker.isSet((Period) o.getMandatoryEarlyTerminationDateTenor()))
				.put("optionalEarlyTermination", ExistenceChecker.isSet((OptionalEarlyTermination) o.getOptionalEarlyTermination()))
				.put("optionalEarlyTerminationParameters", ExistenceChecker.isSet((ExercisePeriod) o.getOptionalEarlyTerminationParameters()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EarlyTerminationProvision", ValidationResult.ValidationType.ONLY_EXISTS, "EarlyTerminationProvision", path, "");
		}
		return failure("EarlyTerminationProvision", ValidationResult.ValidationType.ONLY_EXISTS, "EarlyTerminationProvision", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
