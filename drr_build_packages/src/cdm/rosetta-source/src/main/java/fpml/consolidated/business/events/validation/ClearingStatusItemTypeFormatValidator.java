package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ClearingStatusItem;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingStatusItemTypeFormatValidator implements Validator<ClearingStatusItem> {

	private List<ComparisonResult> getComparisonResults(ClearingStatusItem o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingStatusItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingStatusItem", ValidationResult.ValidationType.TYPE_FORMAT, "ClearingStatusItem", path, "", res.getError());
				}
				return success("ClearingStatusItem", ValidationResult.ValidationType.TYPE_FORMAT, "ClearingStatusItem", path, "");
			})
			.collect(toList());
	}

}
