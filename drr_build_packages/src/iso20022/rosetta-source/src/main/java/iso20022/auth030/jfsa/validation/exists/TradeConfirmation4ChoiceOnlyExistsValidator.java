package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeConfirmation4Choice;
import iso20022.auth030.jfsa.TradeConfirmation5;
import iso20022.auth030.jfsa.TradeNonConfirmation1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeConfirmation4ChoiceOnlyExistsValidator implements ValidatorWithArg<TradeConfirmation4Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeConfirmation4Choice> ValidationResult<TradeConfirmation4Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("confd", ExistenceChecker.isSet((TradeConfirmation5) o.getConfd()))
				.put("nonConfd", ExistenceChecker.isSet((TradeNonConfirmation1) o.getNonConfd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeConfirmation4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "TradeConfirmation4Choice", path, "");
		}
		return failure("TradeConfirmation4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "TradeConfirmation4Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
