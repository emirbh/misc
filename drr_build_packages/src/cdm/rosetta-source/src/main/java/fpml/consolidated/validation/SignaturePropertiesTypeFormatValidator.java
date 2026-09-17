package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SignatureProperties;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SignaturePropertiesTypeFormatValidator implements Validator<SignatureProperties> {

	private List<ComparisonResult> getComparisonResults(SignatureProperties o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignatureProperties o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignatureProperties", ValidationResult.ValidationType.TYPE_FORMAT, "SignatureProperties", path, "", res.getError());
				}
				return success("SignatureProperties", ValidationResult.ValidationType.TYPE_FORMAT, "SignatureProperties", path, "");
			})
			.collect(toList());
	}

}
