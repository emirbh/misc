package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.FxAccrualKnockoutBarrierRetentionEnum;
import fpml.consolidated.fpmlenum.FxBarrierScopeEnum;
import fpml.consolidated.fpmlenum.FxBarrierStyleEnum;
import fpml.consolidated.fpmlenum.FxBarrierTypeSimpleEnum;
import fpml.consolidated.fx.accruals.FxAccrualBarrier;
import fpml.consolidated.fx.accruals.FxRateObservableReference;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.Schedule;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualBarrierValidator implements Validator<FxAccrualBarrier> {

	private List<ComparisonResult> getComparisonResults(FxAccrualBarrier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrierType", (FxBarrierTypeSimpleEnum) o.getBarrierType() != null ? 1 : 0, 0, 1), 
				checkCardinality("style", (FxBarrierStyleEnum) o.getStyle() != null ? 1 : 0, 1, 1), 
				checkCardinality("scope", (FxBarrierScopeEnum) o.getScope() != null ? 1 : 0, 0, 1), 
				checkCardinality("condition", (ConditionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("triggerRate", (Schedule) o.getTriggerRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationStartDate", (ZonedDateTime) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartTime", (BusinessCenterTime) o.getObservationStartTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationEndDate", (ZonedDateTime) o.getObservationEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationEndTime", (BusinessCenterTime) o.getObservationEndTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualRetention", (FxAccrualKnockoutBarrierRetentionEnum) o.getAccrualRetention() != null ? 1 : 0, 0, 1), 
				checkCardinality("observableReference", (FxRateObservableReference) o.getObservableReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualBarrier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualBarrier", ValidationResult.ValidationType.CARDINALITY, "FxAccrualBarrier", path, "", res.getError());
				}
				return success("FxAccrualBarrier", ValidationResult.ValidationType.CARDINALITY, "FxAccrualBarrier", path, "");
			})
			.collect(toList());
	}

}
