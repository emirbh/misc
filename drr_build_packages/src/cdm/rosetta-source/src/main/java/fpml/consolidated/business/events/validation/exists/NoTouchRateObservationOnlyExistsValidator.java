package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.NoTouchLowerBarrierObservation;
import fpml.consolidated.business.events.NoTouchRateObservation;
import fpml.consolidated.business.events.NoTouchUpperBarrierObservation;
import fpml.consolidated.business.events.PhysicalSettlement;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.SimplePayment;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchRateObservationOnlyExistsValidator implements ValidatorWithArg<NoTouchRateObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchRateObservation> ValidationResult<NoTouchRateObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationStartDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationStartDate()))
				.put("observationEndDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationEndDate()))
				.put("lowerBarrier", ExistenceChecker.isSet((NoTouchLowerBarrierObservation) o.getLowerBarrier()))
				.put("upperBarrier", ExistenceChecker.isSet((NoTouchUpperBarrierObservation) o.getUpperBarrier()))
				.put("exerciseSide", ExistenceChecker.isSet((ExerciseSideEnum) o.getExerciseSide()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("cashSettlement", ExistenceChecker.isSet((SimplePayment) o.getCashSettlement()))
				.put("physicalSettlement", ExistenceChecker.isSet((PhysicalSettlement) o.getPhysicalSettlement()))
				.put("payment", ExistenceChecker.isSet((NonNegativePayment) o.getPayment()))
				.put("clearingInstructions", ExistenceChecker.isSet((ClearingInstructions) o.getClearingInstructions()))
				.put("isExercisable", ExistenceChecker.isSet((Boolean) o.getIsExercisable()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchRateObservation", ValidationResult.ValidationType.ONLY_EXISTS, "NoTouchRateObservation", path, "");
		}
		return failure("NoTouchRateObservation", ValidationResult.ValidationType.ONLY_EXISTS, "NoTouchRateObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
