package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.Cleared23Choice__1;
import iso20022.auth030.fca.ClearingObligationType1Code;
import iso20022.auth030.fca.TradeClearing11__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeClearing11__1OnlyExistsValidator implements ValidatorWithArg<TradeClearing11__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeClearing11__1> ValidationResult<TradeClearing11__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("clrOblgtn", ExistenceChecker.isSet((ClearingObligationType1Code) o.getClrOblgtn()))
				.put("clrSts", ExistenceChecker.isSet((Cleared23Choice__1) o.getClrSts()))
				.put("intraGrp", ExistenceChecker.isSet((Boolean) o.getIntraGrp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeClearing11__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeClearing11__1", path, "");
		}
		return failure("TradeClearing11__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeClearing11__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
