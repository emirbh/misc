package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.ContractValuationData8__1;
import iso20022.auth030.asic.CounterpartySpecificData36__3;
import iso20022.auth030.asic.TradeCounterpartyReport20__3;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CounterpartySpecificData36__3OnlyExistsValidator implements ValidatorWithArg<CounterpartySpecificData36__3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CounterpartySpecificData36__3> ValidationResult<CounterpartySpecificData36__3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPty", ExistenceChecker.isSet((TradeCounterpartyReport20__3) o.getCtrPty()))
				.put("valtn", ExistenceChecker.isSet((ContractValuationData8__1) o.getValtn()))
				.put("rptgTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getRptgTmStmp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CounterpartySpecificData36__3", ValidationResult.ValidationType.ONLY_EXISTS, "CounterpartySpecificData36__3", path, "");
		}
		return failure("CounterpartySpecificData36__3", ValidationResult.ValidationType.ONLY_EXISTS, "CounterpartySpecificData36__3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
