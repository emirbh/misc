package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.ird.FinalCalculationPeriodDateAdjustment;
import fpml.consolidated.ird.InterestRateStreamReference;
import fpml.consolidated.ird.RelevantUnderlyingDateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FinalCalculationPeriodDateAdjustmentValidator implements Validator<FinalCalculationPeriodDateAdjustment> {

	private List<ComparisonResult> getComparisonResults(FinalCalculationPeriodDateAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("relevantUnderlyingDateReference", (RelevantUnderlyingDateReference) o.getRelevantUnderlyingDateReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("swapStreamReference", (InterestRateStreamReference) o.getSwapStreamReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessDayConvention", (BusinessDayConventionEnum) o.getBusinessDayConvention() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalCalculationPeriodDateAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinalCalculationPeriodDateAdjustment", ValidationResult.ValidationType.CARDINALITY, "FinalCalculationPeriodDateAdjustment", path, "", res.getError());
				}
				return success("FinalCalculationPeriodDateAdjustment", ValidationResult.ValidationType.CARDINALITY, "FinalCalculationPeriodDateAdjustment", path, "");
			})
			.collect(toList());
	}

}
