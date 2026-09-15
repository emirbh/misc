package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.NumberOfOptionsReference;
import fpml.consolidated.shared.NumberOfUnitsReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeLegSizeChangeValidator implements Validator<TradeLegSizeChange> {

	private List<ComparisonResult> getComparisonResults(TradeLegSizeChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalReference", (NotionalReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInNotionalAmount", (NonNegativeMoney) o.getChangeInNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNotionalAmount", (NonNegativeMoney) o.getOutstandingNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfOptionsReference", (NumberOfOptionsReference) o.getNumberOfOptionsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInNumberOfOptions", (BigDecimal) o.getChangeInNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfOptions", (BigDecimal) o.getOutstandingNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfUnitsReference", (NumberOfUnitsReference) o.getNumberOfUnitsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInNumberOfUnits", (BigDecimal) o.getChangeInNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfUnits", (BigDecimal) o.getOutstandingNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalScheduleReference", (NotionalReference) o.getNotionalScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInNotionalSchedule", (NonNegativeAmountSchedule) o.getChangeInNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNotionalSchedule", (NonNegativeAmountSchedule) o.getOutstandingNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("knownAmountReference", (AmountReference) o.getKnownAmountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("changeInKnownAmount", (NonNegativeMoney) o.getChangeInKnownAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingKnownAmount", (NonNegativeMoney) o.getOutstandingKnownAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegSizeChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegSizeChange", ValidationResult.ValidationType.CARDINALITY, "TradeLegSizeChange", path, "", res.getError());
				}
				return success("TradeLegSizeChange", ValidationResult.ValidationType.CARDINALITY, "TradeLegSizeChange", path, "");
			})
			.collect(toList());
	}

}
