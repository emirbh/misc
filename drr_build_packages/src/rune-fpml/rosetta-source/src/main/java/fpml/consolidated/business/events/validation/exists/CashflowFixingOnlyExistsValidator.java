package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CashflowFixing;
import fpml.consolidated.business.events.CashflowObservationReference;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.Strike;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CashflowFixingOnlyExistsValidator implements ValidatorWithArg<CashflowFixing, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CashflowFixing> ValidationResult<CashflowFixing> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("observationReference", ExistenceChecker.isSet((List<? extends CashflowObservationReference>) o.getObservationReference()))
				.put("calculatedValue", ExistenceChecker.isSet((BigDecimal) o.getCalculatedValue()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.put("spread", ExistenceChecker.isSet((BigDecimal) o.getSpread()))
				.put("capValue", ExistenceChecker.isSet((List<? extends Strike>) o.getCapValue()))
				.put("floorValue", ExistenceChecker.isSet((List<? extends Strike>) o.getFloorValue()))
				.put("negativeInterestRate", ExistenceChecker.isSet((Boolean) o.getNegativeInterestRate()))
				.put("rounding", ExistenceChecker.isSet((Rounding) o.getRounding()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashflowFixing", ValidationResult.ValidationType.ONLY_EXISTS, "CashflowFixing", path, "");
		}
		return failure("CashflowFixing", ValidationResult.ValidationType.ONLY_EXISTS, "CashflowFixing", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
