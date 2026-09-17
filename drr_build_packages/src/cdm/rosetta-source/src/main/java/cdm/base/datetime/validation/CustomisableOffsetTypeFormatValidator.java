package cdm.base.datetime.validation;

import cdm.base.datetime.CustomisableOffset;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CustomisableOffsetTypeFormatValidator implements Validator<CustomisableOffset> {

	private List<ComparisonResult> getComparisonResults(CustomisableOffset o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustomisableOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustomisableOffset", ValidationResult.ValidationType.TYPE_FORMAT, "CustomisableOffset", path, "", res.getError());
				}
				return success("CustomisableOffset", ValidationResult.ValidationType.TYPE_FORMAT, "CustomisableOffset", path, "");
			})
			.collect(toList());
	}

}
