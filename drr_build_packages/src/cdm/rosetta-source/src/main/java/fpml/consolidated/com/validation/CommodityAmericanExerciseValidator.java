package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityMultipleExercise;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.Frequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityAmericanExerciseValidator implements Validator<CommodityAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(CommodityAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseFrequency", (Frequency) o.getExerciseFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTime", (BusinessCenterTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTimeDetermination", (DeterminationMethod) o.getLatestExerciseTimeDetermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (BusinessCenterTime) o.getExpirationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("multipleExercise", (CommodityMultipleExercise) o.getMultipleExercise() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityAmericanExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityAmericanExercise", path, "", res.getError());
				}
				return success("CommodityAmericanExercise", ValidationResult.ValidationType.CARDINALITY, "CommodityAmericanExercise", path, "");
			})
			.collect(toList());
	}

}
