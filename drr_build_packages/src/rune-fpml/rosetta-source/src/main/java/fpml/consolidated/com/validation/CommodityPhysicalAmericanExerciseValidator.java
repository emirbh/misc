package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPhysicalAmericanExercise;
import fpml.consolidated.com.CommodityRelativeExpirationDates;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.PrevailingTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalAmericanExerciseValidator implements Validator<CommodityPhysicalAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commencementDates", (AdjustableOrRelativeDates) o.getCommencementDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDates", (AdjustableOrRelativeDates) o.getExpirationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeCommencementDates", (CommodityRelativeExpirationDates) o.getRelativeCommencementDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeExpirationDates", (CommodityRelativeExpirationDates) o.getRelativeExpirationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTime", (PrevailingTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (PrevailingTime) o.getExpirationTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalAmericanExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityPhysicalAmericanExercise", path, "", res.getError());
				}
				return success("CommodityPhysicalAmericanExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityPhysicalAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
