package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SignatureValue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SignatureValueTypeFormatValidator implements Validator<SignatureValue> {

	private List<ComparisonResult> getComparisonResults(SignatureValue o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignatureValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignatureValue", ValidationResult.ValidationType.TYPE_FORMAT, "SignatureValue", path, "", res.getError());
				}
				return success("SignatureValue", ValidationResult.ValidationType.TYPE_FORMAT, "SignatureValue", path, "");
			})
			.collect(toList());
	}

}
