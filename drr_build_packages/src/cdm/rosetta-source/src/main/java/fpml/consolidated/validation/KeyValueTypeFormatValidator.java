package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.KeyValue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class KeyValueTypeFormatValidator implements Validator<KeyValue> {

	private List<ComparisonResult> getComparisonResults(KeyValue o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KeyValue", ValidationResult.ValidationType.TYPE_FORMAT, "KeyValue", path, "", res.getError());
				}
				return success("KeyValue", ValidationResult.ValidationType.TYPE_FORMAT, "KeyValue", path, "");
			})
			.collect(toList());
	}

}
