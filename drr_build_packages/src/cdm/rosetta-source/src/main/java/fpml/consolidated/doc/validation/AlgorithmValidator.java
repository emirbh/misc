package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.Algorithm;
import fpml.consolidated.doc.AlgorithmRole;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AlgorithmValidator implements Validator<Algorithm> {

	private List<ComparisonResult> getComparisonResults(Algorithm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (AlgorithmRole) o.getRole() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Algorithm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Algorithm", ValidationResult.ValidationType.CARDINALITY, "Algorithm", path, "", res.getError());
				}
				return success("Algorithm", ValidationResult.ValidationType.CARDINALITY, "Algorithm", path, "");
			})
			.collect(toList());
	}

}
