package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AmountAndDirection109__2;
import iso20022.auth030.fca.ContractValuationData8__2;
import iso20022.auth030.fca.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ContractValuationData8__2OnlyExistsValidator implements ValidatorWithArg<ContractValuationData8__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ContractValuationData8__2> ValidationResult<ContractValuationData8__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrctVal", ExistenceChecker.isSet((AmountAndDirection109__2) o.getCtrctVal()))
				.put("tmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getTmStmp()))
				.put("tp", ExistenceChecker.isSet((ValuationType1Code) o.getTp()))
				.put("dlta", ExistenceChecker.isSet((BigDecimal) o.getDlta()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ContractValuationData8__2", ValidationResult.ValidationType.ONLY_EXISTS, "ContractValuationData8__2", path, "");
		}
		return failure("ContractValuationData8__2", ValidationResult.ValidationType.ONLY_EXISTS, "ContractValuationData8__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
