package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityEuropeanExercise;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityEuropeanExerciseValidator implements Validator<EquityEuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(EquityEuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityExpirationTimeType", (TimeTypeEnum) o.getEquityExpirationTimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExpirationTime", (BusinessCenterTime) o.getEquityExpirationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTimeDetermination", (DeterminationMethod) o.getExpirationTimeDetermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityEuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityEuropeanExercise", ValidationResult.ValidationType.CARDINALITY, "EquityEuropeanExercise", path, "", res.getError());
				}
				return success("EquityEuropeanExercise", ValidationResult.ValidationType.CARDINALITY, "EquityEuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
