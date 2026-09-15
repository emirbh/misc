package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AmountAndDirection109__1;
import iso20022.auth030.esma.ContractValuationData8__1;
import iso20022.auth030.esma.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ContractValuationData8__1OnlyExistsValidator implements ValidatorWithArg<ContractValuationData8__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ContractValuationData8__1> ValidationResult<ContractValuationData8__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrctVal", ExistenceChecker.isSet((AmountAndDirection109__1) o.getCtrctVal()))
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
			return success("ContractValuationData8__1", ValidationResult.ValidationType.ONLY_EXISTS, "ContractValuationData8__1", path, "");
		}
		return failure("ContractValuationData8__1", ValidationResult.ValidationType.ONLY_EXISTS, "ContractValuationData8__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
