package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AutomaticExercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.ManualExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExerciseProcedureValidator implements Validator<ExerciseProcedure> {

	private List<ComparisonResult> getComparisonResults(ExerciseProcedure o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("manualExercise", (ManualExercise) o.getManualExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("automaticExercise", (AutomaticExercise) o.getAutomaticExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("followUpConfirmation", (Boolean) o.getFollowUpConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("limitedRightToConfirm", (Boolean) o.getLimitedRightToConfirm() != null ? 1 : 0, 0, 1), 
				checkCardinality("splitTicket", (Boolean) o.getSplitTicket() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedure o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseProcedure", ValidationResult.ValidationType.CARDINALITY, "ExerciseProcedure", path, "", res.getError());
				}
				return success("ExerciseProcedure", ValidationResult.ValidationType.CARDINALITY, "ExerciseProcedure", path, "");
			})
			.collect(toList());
	}

}
