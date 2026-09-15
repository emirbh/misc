package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.KeyInfo;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class KeyInfoTypeFormatValidator implements Validator<KeyInfo> {

	private List<ComparisonResult> getComparisonResults(KeyInfo o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyInfo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KeyInfo", ValidationResult.ValidationType.TYPE_FORMAT, "KeyInfo", path, "", res.getError());
				}
				return success("KeyInfo", ValidationResult.ValidationType.TYPE_FORMAT, "KeyInfo", path, "");
			})
			.collect(toList());
	}

}
