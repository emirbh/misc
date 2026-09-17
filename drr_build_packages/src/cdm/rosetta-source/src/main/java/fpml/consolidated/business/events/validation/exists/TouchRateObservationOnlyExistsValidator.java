package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.PhysicalSettlement;
import fpml.consolidated.business.events.TouchRateObservation;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TouchRateObservationOnlyExistsValidator implements ValidatorWithArg<TouchRateObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TouchRateObservation> ValidationResult<TouchRateObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationDate()))
				.put("observationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getObservationTime()))
				.put("informationSource", ExistenceChecker.isSet((InformationSource) o.getInformationSource()))
				.put("triggerRate", ExistenceChecker.isSet((BigDecimal) o.getTriggerRate()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("observedRate", ExistenceChecker.isSet((BigDecimal) o.getObservedRate()))
				.put("triggerPrice", ExistenceChecker.isSet((PositiveMoney) o.getTriggerPrice()))
				.put("observedPrice", ExistenceChecker.isSet((PositiveMoney) o.getObservedPrice()))
				.put("triggerCondition", ExistenceChecker.isSet((TriggerConditionEnum) o.getTriggerCondition()))
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
			return success("TouchRateObservation", ValidationResult.ValidationType.ONLY_EXISTS, "TouchRateObservation", path, "");
		}
		return failure("TouchRateObservation", ValidationResult.ValidationType.ONLY_EXISTS, "TouchRateObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
