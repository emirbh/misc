package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import fpml.consolidated.business.events.PhysicalSettlement;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.ExerciseActionEnum;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.fpmlenum.ExerciseTimingEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseOnlyExistsValidator implements ValidatorWithArg<OptionExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExercise> ValidationResult<OptionExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("optionSeller", ExistenceChecker.isSet((PartyReference) o.getOptionSeller()))
				.put("optionBuyer", ExistenceChecker.isSet((PartyReference) o.getOptionBuyer()))
				.put("originalTrade", ExistenceChecker.isSet((Trade) o.getOriginalTrade()))
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getTradeIdentifier()))
				.put("exerciseDate", ExistenceChecker.isSet((ZonedDateTime) o.getExerciseDate()))
				.put("exerciseTime", ExistenceChecker.isSet((LocalTime) o.getExerciseTime()))
				.put("exerciseTiming", ExistenceChecker.isSet((ExerciseTimingEnum) o.getExerciseTiming()))
				.put("exerciseAction", ExistenceChecker.isSet((ExerciseActionEnum) o.getExerciseAction()))
				.put("expiry", ExistenceChecker.isSet((Boolean) o.getExpiry()))
				.put("fullExercise", ExistenceChecker.isSet((Boolean) o.getFullExercise()))
				.put("exerciseInNotionalAmount", ExistenceChecker.isSet((Money) o.getExerciseInNotionalAmount()))
				.put("outstandingNotionalAmount", ExistenceChecker.isSet((Money) o.getOutstandingNotionalAmount()))
				.put("exerciseInNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfOptions()))
				.put("outstandingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfOptions()))
				.put("exerciseInNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfUnits()))
				.put("outstandingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfUnits()))
				.put("specifiedExercise", ExistenceChecker.isSet((List<? extends OptionExerciseAmounts>) o.getSpecifiedExercise()))
				.put("exerciseSide", ExistenceChecker.isSet((ExerciseSideEnum) o.getExerciseSide()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("cashSettlement", ExistenceChecker.isSet((SimplePayment) o.getCashSettlement()))
				.put("physicalSettlement", ExistenceChecker.isSet((PhysicalSettlement) o.getPhysicalSettlement()))
				.put("payment", ExistenceChecker.isSet((NonNegativePayment) o.getPayment()))
				.put("clearingInstructions", ExistenceChecker.isSet((ClearingInstructions) o.getClearingInstructions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExercise", ValidationResult.ValidationType.ONLY_EXISTS, "OptionExercise", path, "");
		}
		return failure("OptionExercise", ValidationResult.ValidationType.ONLY_EXISTS, "OptionExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
