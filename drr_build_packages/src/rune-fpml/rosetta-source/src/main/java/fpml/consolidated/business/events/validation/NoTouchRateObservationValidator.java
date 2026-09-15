package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
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
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NoTouchRateObservationValidator implements Validator<NoTouchRateObservation> {

	private List<ComparisonResult> getComparisonResults(NoTouchRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationStartDate", (ZonedDateTime) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationEndDate", (ZonedDateTime) o.getObservationEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBarrier", (NoTouchLowerBarrierObservation) o.getLowerBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBarrier", (NoTouchUpperBarrierObservation) o.getUpperBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseSide", (ExerciseSideEnum) o.getExerciseSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (SimplePayment) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlement", (PhysicalSettlement) o.getPhysicalSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("payment", (NonNegativePayment) o.getPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (ClearingInstructions) o.getClearingInstructions() != null ? 1 : 0, 0, 1), 
				checkCardinality("isExercisable", (Boolean) o.getIsExercisable() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchRateObservation", ValidationResult.ValidationType.CARDINALITY, "NoTouchRateObservation", path, "", res.getError());
				}
				return success("NoTouchRateObservation", ValidationResult.ValidationType.CARDINALITY, "NoTouchRateObservation", path, "");
			})
			.collect(toList());
	}

}
