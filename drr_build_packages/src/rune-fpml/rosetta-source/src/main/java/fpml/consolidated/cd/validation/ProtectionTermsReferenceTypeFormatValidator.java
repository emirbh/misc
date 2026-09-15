package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.ProtectionTermsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProtectionTermsReferenceTypeFormatValidator implements Validator<ProtectionTermsReference> {

	private List<ComparisonResult> getComparisonResults(ProtectionTermsReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProtectionTermsReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProtectionTermsReference", ValidationResult.ValidationType.TYPE_FORMAT, "ProtectionTermsReference", path, "", res.getError());
				}
				return success("ProtectionTermsReference", ValidationResult.ValidationType.TYPE_FORMAT, "ProtectionTermsReference", path, "");
			})
			.collect(toList());
	}

}
