package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.DSAKeyValueType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DSAKeyValueTypeTypeFormatValidator implements Validator<DSAKeyValueType> {

	private List<ComparisonResult> getComparisonResults(DSAKeyValueType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DSAKeyValueType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DSAKeyValueType", ValidationResult.ValidationType.TYPE_FORMAT, "DSAKeyValueType", path, "", res.getError());
				}
				return success("DSAKeyValueType", ValidationResult.ValidationType.TYPE_FORMAT, "DSAKeyValueType", path, "");
			})
			.collect(toList());
	}

}
