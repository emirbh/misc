package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ContractValuationData8__1;
import iso20022.auth030.fca.CounterpartySpecificData36__1;
import iso20022.auth030.fca.TradeCounterpartyReport20__1;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CounterpartySpecificData36__1OnlyExistsValidator implements ValidatorWithArg<CounterpartySpecificData36__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CounterpartySpecificData36__1> ValidationResult<CounterpartySpecificData36__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPty", ExistenceChecker.isSet((TradeCounterpartyReport20__1) o.getCtrPty()))
				.put("valtn", ExistenceChecker.isSet((ContractValuationData8__1) o.getValtn()))
				.put("rptgTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getRptgTmStmp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CounterpartySpecificData36__1", ValidationResult.ValidationType.ONLY_EXISTS, "CounterpartySpecificData36__1", path, "");
		}
		return failure("CounterpartySpecificData36__1", ValidationResult.ValidationType.ONLY_EXISTS, "CounterpartySpecificData36__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
