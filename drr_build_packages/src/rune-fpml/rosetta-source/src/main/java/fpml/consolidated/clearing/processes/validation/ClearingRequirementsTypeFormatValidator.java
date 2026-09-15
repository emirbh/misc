package fpml.consolidated.clearing.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.clearing.processes.ClearingRequirements;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingRequirementsTypeFormatValidator implements Validator<ClearingRequirements> {

	private List<ComparisonResult> getComparisonResults(ClearingRequirements o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingRequirements o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingRequirements", ValidationResult.ValidationType.TYPE_FORMAT, "ClearingRequirements", path, "", res.getError());
				}
				return success("ClearingRequirements", ValidationResult.ValidationType.TYPE_FORMAT, "ClearingRequirements", path, "");
			})
			.collect(toList());
	}

}
