package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.TouchConditionEnum;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.fx.FxTouch;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTouchValidator implements Validator<FxTouch> {

	private List<ComparisonResult> getComparisonResults(FxTouch o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("touchCondition", (TouchConditionEnum) o.getTouchCondition() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction", (TriggerConditionEnum) o.getDirection() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartDate", (ZonedDateTime) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartTime", (BusinessCenterTime) o.getObservationStartTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationEndDate", (ZonedDateTime) o.getObservationEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationEndTime", (BusinessCenterTime) o.getObservationEndTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTouch o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTouch", ValidationResult.ValidationType.CARDINALITY, "FxTouch", path, "", res.getError());
				}
				return success("FxTouch", ValidationResult.ValidationType.CARDINALITY, "FxTouch", path, "");
			})
			.collect(toList());
	}

}
