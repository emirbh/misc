package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.PhysicalSettlement;
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

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionExerciseValidator implements Validator<OptionExercise> {

	private List<ComparisonResult> getComparisonResults(OptionExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionSeller", (PartyReference) o.getOptionSeller() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionBuyer", (PartyReference) o.getOptionBuyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseDate", (ZonedDateTime) o.getExerciseDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseTime", (LocalTime) o.getExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseTiming", (ExerciseTimingEnum) o.getExerciseTiming() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseAction", (ExerciseActionEnum) o.getExerciseAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiry", (Boolean) o.getExpiry() != null ? 1 : 0, 0, 1), 
				checkCardinality("fullExercise", (Boolean) o.getFullExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNotionalAmount", (Money) o.getExerciseInNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNotionalAmount", (Money) o.getOutstandingNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNumberOfOptions", (BigDecimal) o.getExerciseInNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfOptions", (BigDecimal) o.getOutstandingNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNumberOfUnits", (BigDecimal) o.getExerciseInNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfUnits", (BigDecimal) o.getOutstandingNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseSide", (ExerciseSideEnum) o.getExerciseSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (SimplePayment) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlement", (PhysicalSettlement) o.getPhysicalSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("payment", (NonNegativePayment) o.getPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (ClearingInstructions) o.getClearingInstructions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExercise", ValidationResult.ValidationType.CARDINALITY, "OptionExercise", path, "", res.getError());
				}
				return success("OptionExercise", ValidationResult.ValidationType.CARDINALITY, "OptionExercise", path, "");
			})
			.collect(toList());
	}

}
