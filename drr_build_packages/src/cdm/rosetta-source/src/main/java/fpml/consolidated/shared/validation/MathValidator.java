package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MathValidator implements Validator<fpml.consolidated.shared.Math> {

	private List<ComparisonResult> getComparisonResults(fpml.consolidated.shared.Math o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("anyContents", (List<String>) o.getAnyContents() == null ? 0 : o.getAnyContents().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, fpml.consolidated.shared.Math o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Math", ValidationResult.ValidationType.CARDINALITY, "Math", path, "", res.getError());
				}
				return success("Math", ValidationResult.ValidationType.CARDINALITY, "Math", path, "");
			})
			.collect(toList());
	}

}
