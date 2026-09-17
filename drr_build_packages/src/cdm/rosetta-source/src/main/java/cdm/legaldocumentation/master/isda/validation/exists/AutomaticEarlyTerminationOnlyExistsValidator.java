package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.legaldocumentation.master.isda.AutomaticEarlyTermination;
import cdm.legaldocumentation.master.isda.AutomaticEarlyTerminationElection;
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

public class AutomaticEarlyTerminationOnlyExistsValidator implements ValidatorWithArg<AutomaticEarlyTermination, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AutomaticEarlyTermination> ValidationResult<AutomaticEarlyTermination> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fallbackAET", ExistenceChecker.isSet((Boolean) o.getFallbackAET()))
				.put("indemnity", ExistenceChecker.isSet((Boolean) o.getIndemnity()))
				.put("partyElection", ExistenceChecker.isSet((List<? extends AutomaticEarlyTerminationElection>) o.getPartyElection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AutomaticEarlyTermination", ValidationResult.ValidationType.ONLY_EXISTS, "AutomaticEarlyTermination", path, "");
		}
		return failure("AutomaticEarlyTermination", ValidationResult.ValidationType.ONLY_EXISTS, "AutomaticEarlyTermination", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
