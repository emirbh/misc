package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.TradeConfirmationType2Code;
import iso20022.auth030.esma.TradeNonConfirmation1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeNonConfirmation1OnlyExistsValidator implements ValidatorWithArg<TradeNonConfirmation1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeNonConfirmation1> ValidationResult<TradeNonConfirmation1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tp", ExistenceChecker.isSet((TradeConfirmationType2Code) o.getTp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeNonConfirmation1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeNonConfirmation1", path, "");
		}
		return failure("TradeNonConfirmation1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeNonConfirmation1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
