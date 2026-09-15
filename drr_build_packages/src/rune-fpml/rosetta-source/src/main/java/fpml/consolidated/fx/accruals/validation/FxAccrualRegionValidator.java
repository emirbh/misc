package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualRegion;
import fpml.consolidated.fx.accruals.FxAccrualRegionLowerBound;
import fpml.consolidated.fx.accruals.FxAccrualRegionUpperBound;
import fpml.consolidated.fx.accruals.FxRateObservableReference;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionValidator implements Validator<FxAccrualRegion> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observableReference", (FxRateObservableReference) o.getObservableReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("upperBound", (FxAccrualRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (FxAccrualRegionLowerBound) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualFactor", (Schedule) o.getAccrualFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterCurrencyAmount", (FxCounterCurrencyAmount) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegion", ValidationResult.ValidationType.CARDINALITY, "FxAccrualRegion", path, "", res.getError());
				}
				return success("FxAccrualRegion", ValidationResult.ValidationType.CARDINALITY, "FxAccrualRegion", path, "");
			})
			.collect(toList());
	}

}
