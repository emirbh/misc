package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated._Object;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class _ObjectValidator implements Validator<_Object> {

	private List<ComparisonResult> getComparisonResults(_Object o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("mimeType", (String) o.getMimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("encoding", (String) o.getEncoding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, _Object o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("_Object", ValidationResult.ValidationType.CARDINALITY, "_Object", path, "", res.getError());
				}
				return success("_Object", ValidationResult.ValidationType.CARDINALITY, "_Object", path, "");
			})
			.collect(toList());
	}

}
