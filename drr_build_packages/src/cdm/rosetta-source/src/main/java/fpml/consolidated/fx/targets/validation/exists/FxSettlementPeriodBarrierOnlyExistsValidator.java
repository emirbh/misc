package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxComplexBarrierBaseReference;
import fpml.consolidated.fx.targets.FxSettlementPeriodBarrier;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxSettlementPeriodBarrierOnlyExistsValidator implements ValidatorWithArg<FxSettlementPeriodBarrier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxSettlementPeriodBarrier> ValidationResult<FxSettlementPeriodBarrier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("barrierReference", ExistenceChecker.isSet((FxComplexBarrierBaseReference) o.getBarrierReference()))
				.put("triggerRate", ExistenceChecker.isSet((BigDecimal) o.getTriggerRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxSettlementPeriodBarrier", ValidationResult.ValidationType.ONLY_EXISTS, "FxSettlementPeriodBarrier", path, "");
		}
		return failure("FxSettlementPeriodBarrier", ValidationResult.ValidationType.ONLY_EXISTS, "FxSettlementPeriodBarrier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
