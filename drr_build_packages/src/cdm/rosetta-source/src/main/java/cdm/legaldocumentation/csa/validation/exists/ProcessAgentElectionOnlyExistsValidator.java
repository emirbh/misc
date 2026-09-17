package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyContactInformation;
import cdm.legaldocumentation.csa.ProcessAgentElection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ProcessAgentElectionOnlyExistsValidator implements ValidatorWithArg<ProcessAgentElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ProcessAgentElection> ValidationResult<ProcessAgentElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("isApplicable", ExistenceChecker.isSet((Boolean) o.getIsApplicable()))
				.put("processAgent", ExistenceChecker.isSet((PartyContactInformation) o.getProcessAgent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ProcessAgentElection", ValidationResult.ValidationType.ONLY_EXISTS, "ProcessAgentElection", path, "");
		}
		return failure("ProcessAgentElection", ValidationResult.ValidationType.ONLY_EXISTS, "ProcessAgentElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
