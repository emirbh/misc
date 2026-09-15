package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.RetrievalMethod;
import fpml.consolidated.TransformsType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RetrievalMethodValidator implements Validator<RetrievalMethod> {

	private List<ComparisonResult> getComparisonResults(RetrievalMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("uri", (String) o.getUri() != null ? 1 : 0, 0, 1), 
				checkCardinality("type", (String) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("transforms", (TransformsType) o.getTransforms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RetrievalMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RetrievalMethod", ValidationResult.ValidationType.CARDINALITY, "RetrievalMethod", path, "", res.getError());
				}
				return success("RetrievalMethod", ValidationResult.ValidationType.CARDINALITY, "RetrievalMethod", path, "");
			})
			.collect(toList());
	}

}
