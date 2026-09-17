package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.FxBarrierDirectionEnum;
import fpml.consolidated.fpmlenum.FxBarrierTypeEnum;
import fpml.consolidated.fx.FxBarrierFeature;
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

public class FxBarrierFeatureValidator implements Validator<FxBarrierFeature> {

	private List<ComparisonResult> getComparisonResults(FxBarrierFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("barrierType", (FxBarrierTypeEnum) o.getBarrierType() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction", (FxBarrierDirectionEnum) o.getDirection() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartDate", (ZonedDateTime) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartTime", (BusinessCenterTime) o.getObservationStartTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationEndDate", (ZonedDateTime) o.getObservationEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationEndTime", (BusinessCenterTime) o.getObservationEndTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBarrierFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxBarrierFeature", ValidationResult.ValidationType.CARDINALITY, "FxBarrierFeature", path, "", res.getError());
				}
				return success("FxBarrierFeature", ValidationResult.ValidationType.CARDINALITY, "FxBarrierFeature", path, "");
			})
			.collect(toList());
	}

}
