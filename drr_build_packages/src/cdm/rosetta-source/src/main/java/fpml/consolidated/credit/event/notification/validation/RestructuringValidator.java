package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.Restructuring;
import fpml.consolidated.shared.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RestructuringValidator implements Validator<Restructuring> {

	private List<ComparisonResult> getComparisonResults(Restructuring o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partialExerciseAmount", (Money) o.getPartialExerciseAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Restructuring o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Restructuring", ValidationResult.ValidationType.CARDINALITY, "Restructuring", path, "", res.getError());
				}
				return success("Restructuring", ValidationResult.ValidationType.CARDINALITY, "Restructuring", path, "");
			})
			.collect(toList());
	}

}
