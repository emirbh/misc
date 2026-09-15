package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.ReferencePool;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferencePoolTypeFormatValidator implements Validator<ReferencePool> {

	private List<ComparisonResult> getComparisonResults(ReferencePool o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePool o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferencePool", ValidationResult.ValidationType.TYPE_FORMAT, "ReferencePool", path, "", res.getError());
				}
				return success("ReferencePool", ValidationResult.ValidationType.TYPE_FORMAT, "ReferencePool", path, "");
			})
			.collect(toList());
	}

}
