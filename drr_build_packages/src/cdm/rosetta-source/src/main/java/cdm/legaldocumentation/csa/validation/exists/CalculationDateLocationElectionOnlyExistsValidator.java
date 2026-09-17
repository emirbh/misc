package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.CalculationDateLocationElection;
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

public class CalculationDateLocationElectionOnlyExistsValidator implements ValidatorWithArg<CalculationDateLocationElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationDateLocationElection> ValidationResult<CalculationDateLocationElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("businessCenter", ExistenceChecker.isSet((FieldWithMetaBusinessCenterEnum) o.getBusinessCenter()))
				.put("customLocation", ExistenceChecker.isSet((String) o.getCustomLocation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationDateLocationElection", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationDateLocationElection", path, "");
		}
		return failure("CalculationDateLocationElection", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationDateLocationElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
