package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.Counterparty46__1;
import iso20022.auth030.jfsa.PartyIdentification248Choice__2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Counterparty46__1OnlyExistsValidator implements ValidatorWithArg<Counterparty46__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Counterparty46__1> ValidationResult<Counterparty46__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("idTp", ExistenceChecker.isSet((PartyIdentification248Choice__2) o.getIdTp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Counterparty46__1", ValidationResult.ValidationType.ONLY_EXISTS, "Counterparty46__1", path, "");
		}
		return failure("Counterparty46__1", ValidationResult.ValidationType.ONLY_EXISTS, "Counterparty46__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
