package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeConfirmation5;
import iso20022.auth030.jfsa.TradeConfirmationType1Code;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeConfirmation5OnlyExistsValidator implements ValidatorWithArg<TradeConfirmation5, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeConfirmation5> ValidationResult<TradeConfirmation5> validate(RosettaPath path, T2 o, Set<String> fields) {
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
			return success("TradeConfirmation5", ValidationResult.ValidationType.ONLY_EXISTS, "TradeConfirmation5", path, "");
		}
		return failure("TradeConfirmation5", ValidationResult.ValidationType.ONLY_EXISTS, "TradeConfirmation5", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
