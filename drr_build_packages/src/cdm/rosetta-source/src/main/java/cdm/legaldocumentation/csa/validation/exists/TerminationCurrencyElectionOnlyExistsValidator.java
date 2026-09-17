package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.TerminationCurrencyElection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TerminationCurrencyElectionOnlyExistsValidator implements ValidatorWithArg<TerminationCurrencyElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TerminationCurrencyElection> ValidationResult<TerminationCurrencyElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((List<CounterpartyRoleEnum>) o.getParty()))
				.put("isSpecified", ExistenceChecker.isSet((Boolean) o.getIsSpecified()))
				.put("currency", ExistenceChecker.isSet((FieldWithMetaString) o.getCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TerminationCurrencyElection", ValidationResult.ValidationType.ONLY_EXISTS, "TerminationCurrencyElection", path, "");
		}
		return failure("TerminationCurrencyElection", ValidationResult.ValidationType.ONLY_EXISTS, "TerminationCurrencyElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
