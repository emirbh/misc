package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.Material;
import fpml.consolidated.com.Metal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MetalValidator implements Validator<Metal> {

	private List<ComparisonResult> getComparisonResults(Metal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("material", (Material) o.getMaterial() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Metal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Metal", ValidationResult.ValidationType.CARDINALITY, "Metal", path, "", res.getError());
				}
				return success("Metal", ValidationResult.ValidationType.CARDINALITY, "Metal", path, "");
			})
			.collect(toList());
	}

}
