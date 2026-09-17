package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
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
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TouchRateObservationValidator implements Validator<TouchRateObservation> {

	private List<ComparisonResult> getComparisonResults(TouchRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationDate", (ZonedDateTime) o.getObservationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationTime", (BusinessCenterTime) o.getObservationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("observedRate", (BigDecimal) o.getObservedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerPrice", (PositiveMoney) o.getTriggerPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("observedPrice", (PositiveMoney) o.getObservedPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerCondition", (TriggerConditionEnum) o.getTriggerCondition() != null ? 1 : 0, 0, 1), 
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
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TouchRateObservation", ValidationResult.ValidationType.CARDINALITY, "TouchRateObservation", path, "", res.getError());
				}
				return success("TouchRateObservation", ValidationResult.ValidationType.CARDINALITY, "TouchRateObservation", path, "");
			})
			.collect(toList());
	}

}
