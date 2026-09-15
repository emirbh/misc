package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeConfirmation2;
import iso20022.auth030.fca.TradeConfirmationType1Code;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeConfirmation2OnlyExistsValidator implements ValidatorWithArg<TradeConfirmation2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeConfirmation2> ValidationResult<TradeConfirmation2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tp", ExistenceChecker.isSet((TradeConfirmationType1Code) o.getTp()))
				.put("tmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getTmStmp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeConfirmation2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeConfirmation2", path, "");
		}
		return failure("TradeConfirmation2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeConfirmation2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
