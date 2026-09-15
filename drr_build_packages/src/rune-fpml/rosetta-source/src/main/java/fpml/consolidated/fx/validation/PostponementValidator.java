package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.Postponement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PostponementValidator implements Validator<Postponement> {

	private List<ComparisonResult> getComparisonResults(Postponement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("maximumNumberOfDays", (Integer) o.getMaximumNumberOfDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Postponement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Postponement", ValidationResult.ValidationType.CARDINALITY, "Postponement", path, "", res.getError());
				}
				return success("Postponement", ValidationResult.ValidationType.CARDINALITY, "Postponement", path, "");
			})
			.collect(toList());
	}

}
