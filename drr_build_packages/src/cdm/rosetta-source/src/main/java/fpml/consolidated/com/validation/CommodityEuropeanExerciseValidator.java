package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Frequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityEuropeanExerciseValidator implements Validator<CommodityEuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityEuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseFrequency", (Frequency) o.getExerciseFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (BusinessCenterTime) o.getExpirationTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityEuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityEuropeanExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityEuropeanExercise", path, "", res.getError());
				}
				return success("CommodityEuropeanExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityEuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
