package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityExercisePeriods;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityExercisePeriodsValidator implements Validator<CommodityExercisePeriods> {

	private List<ComparisonResult> getComparisonResults(CommodityExercisePeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commencementDate", (AdjustableOrRelativeDate) o.getCommencementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityExercisePeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityExercisePeriods", ValidationResult.ValidationType.CARDINALITY, "CommodityExercisePeriods", path, "", res.getError());
				}
				return success("CommodityExercisePeriods", ValidationResult.ValidationType.CARDINALITY, "CommodityExercisePeriods", path, "");
			})
			.collect(toList());
	}

}
