package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.base.math.Quantity;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.legaldocumentation.transaction.additionalterms.EventCurrency;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventCurrencyOnlyExistsValidator implements ValidatorWithArg<EventCurrency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventCurrency> ValidationResult<EventCurrency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventCurrency", ExistenceChecker.isSet((FieldWithMetaString) o.getEventCurrency()))
				.put("eventCurrentAmount", ExistenceChecker.isSet((Quantity) o.getEventCurrentAmount()))
				.put("eventCurrencyBuyerSeller", ExistenceChecker.isSet((List<? extends BuyerSeller>) o.getEventCurrencyBuyerSeller()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "EventCurrency", path, "");
		}
		return failure("EventCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "EventCurrency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
