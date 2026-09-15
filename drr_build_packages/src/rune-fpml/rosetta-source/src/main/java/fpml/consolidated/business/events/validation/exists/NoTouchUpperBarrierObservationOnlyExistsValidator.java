package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.NoTouchUpperBarrierObservation;
import fpml.consolidated.business.events.ObservedPrice;
import fpml.consolidated.business.events.ObservedRate;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchUpperBarrierObservationOnlyExistsValidator implements ValidatorWithArg<NoTouchUpperBarrierObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchUpperBarrierObservation> ValidationResult<NoTouchUpperBarrierObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("triggerRate", ExistenceChecker.isSet((BigDecimal) o.getTriggerRate()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("maximumObservedRate", ExistenceChecker.isSet((ObservedRate) o.getMaximumObservedRate()))
				.put("triggerPrice", ExistenceChecker.isSet((PositiveMoney) o.getTriggerPrice()))
				.put("maximumObservedPrice", ExistenceChecker.isSet((ObservedPrice) o.getMaximumObservedPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchUpperBarrierObservation", ValidationResult.ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservation", path, "");
		}
		return failure("NoTouchUpperBarrierObservation", ValidationResult.ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
