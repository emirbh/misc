package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ActionOnExpiration;
import fpml.consolidated.fpmlenum.ExerciseActionEnum;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ActionOnExpirationValidator implements Validator<ActionOnExpiration> {

	private List<ComparisonResult> getComparisonResults(ActionOnExpiration o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exerciseAction", (ExerciseActionEnum) o.getExerciseAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiry", (Boolean) o.getExpiry() != null ? 1 : 0, 0, 1), 
				checkCardinality("fullExercise", (Boolean) o.getFullExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNotionalAmount", (Money) o.getExerciseInNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNotionalAmount", (Money) o.getOutstandingNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNumberOfOptions", (BigDecimal) o.getExerciseInNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfOptions", (BigDecimal) o.getOutstandingNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNumberOfUnits", (BigDecimal) o.getExerciseInNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingNumberOfUnits", (BigDecimal) o.getOutstandingNumberOfUnits() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActionOnExpiration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActionOnExpiration", ValidationResult.ValidationType.CARDINALITY, "ActionOnExpiration", path, "", res.getError());
				}
				return success("ActionOnExpiration", ValidationResult.ValidationType.CARDINALITY, "ActionOnExpiration", path, "");
			})
			.collect(toList());
	}

}
