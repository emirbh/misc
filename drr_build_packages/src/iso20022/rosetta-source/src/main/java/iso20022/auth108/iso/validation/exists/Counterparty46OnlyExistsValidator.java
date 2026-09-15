package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.Counterparty46;
import iso20022.auth108.iso.CounterpartyTradeNature15Choice;
import iso20022.auth108.iso.PartyIdentification248Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Counterparty46OnlyExistsValidator implements ValidatorWithArg<Counterparty46, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Counterparty46> ValidationResult<Counterparty46> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("idTp", ExistenceChecker.isSet((PartyIdentification248Choice) o.getIdTp()))
				.put("ntr", ExistenceChecker.isSet((CounterpartyTradeNature15Choice) o.getNtr()))
				.put("rptgOblgtn", ExistenceChecker.isSet((Boolean) o.getRptgOblgtn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Counterparty46", ValidationResult.ValidationType.ONLY_EXISTS, "Counterparty46", path, "");
		}
		return failure("Counterparty46", ValidationResult.ValidationType.ONLY_EXISTS, "Counterparty46", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
