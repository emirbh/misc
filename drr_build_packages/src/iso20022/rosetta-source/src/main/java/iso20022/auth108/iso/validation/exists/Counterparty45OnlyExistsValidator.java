package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.Counterparty45;
import iso20022.auth108.iso.CounterpartyTradeNature15Choice;
import iso20022.auth108.iso.Direction4Choice;
import iso20022.auth108.iso.PartyIdentification248Choice;
import iso20022.auth108.iso.ReportingExemption1;
import iso20022.auth108.iso.TradingCapacity7Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Counterparty45OnlyExistsValidator implements ValidatorWithArg<Counterparty45, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Counterparty45> ValidationResult<Counterparty45> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((PartyIdentification248Choice) o.getId()))
				.put("ntr", ExistenceChecker.isSet((CounterpartyTradeNature15Choice) o.getNtr()))
				.put("tradgCpcty", ExistenceChecker.isSet((TradingCapacity7Code) o.getTradgCpcty()))
				.put("drctnOrSd", ExistenceChecker.isSet((Direction4Choice) o.getDrctnOrSd()))
				.put("tradrLctn", ExistenceChecker.isSet((String) o.getTradrLctn()))
				.put("bookgLctn", ExistenceChecker.isSet((String) o.getBookgLctn()))
				.put("rptgXmptn", ExistenceChecker.isSet((ReportingExemption1) o.getRptgXmptn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Counterparty45", ValidationResult.ValidationType.ONLY_EXISTS, "Counterparty45", path, "");
		}
		return failure("Counterparty45", ValidationResult.ValidationType.ONLY_EXISTS, "Counterparty45", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
