package drr.base.trade.basket.validation.exists;

import cdm.base.staticdata.party.PartyIdentifier;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.basket.CustomBasket;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CustomBasketOnlyExistsValidator implements ValidatorWithArg<CustomBasket, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CustomBasket> ValidationResult<CustomBasket> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basketStructurerLei", ExistenceChecker.isSet((PartyIdentifier) o.getBasketStructurerLei()))
				.put("customBasketCode", ExistenceChecker.isSet((String) o.getCustomBasketCode()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustomBasket", ValidationResult.ValidationType.ONLY_EXISTS, "CustomBasket", path, "");
		}
		return failure("CustomBasket", ValidationResult.ValidationType.ONLY_EXISTS, "CustomBasket", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
