package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ExtendibleProvision;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExtendibleProvisionTypeFormatValidator implements Validator<ExtendibleProvision> {

	private List<ComparisonResult> getComparisonResults(ExtendibleProvision o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtendibleProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExtendibleProvision", ValidationResult.ValidationType.TYPE_FORMAT, "ExtendibleProvision", path, "", res.getError());
				}
				return success("ExtendibleProvision", ValidationResult.ValidationType.TYPE_FORMAT, "ExtendibleProvision", path, "");
			})
			.collect(toList());
	}

}
