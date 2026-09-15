package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.PassThroughItem;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PassThroughItemTypeFormatValidator implements Validator<PassThroughItem> {

	private List<ComparisonResult> getComparisonResults(PassThroughItem o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PassThroughItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PassThroughItem", ValidationResult.ValidationType.TYPE_FORMAT, "PassThroughItem", path, "", res.getError());
				}
				return success("PassThroughItem", ValidationResult.ValidationType.TYPE_FORMAT, "PassThroughItem", path, "");
			})
			.collect(toList());
	}

}
