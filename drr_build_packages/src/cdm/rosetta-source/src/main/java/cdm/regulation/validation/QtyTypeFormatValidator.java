package cdm.regulation.validation;

import cdm.regulation.Qty;
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

public class QtyTypeFormatValidator implements Validator<Qty> {

	private List<ComparisonResult> getComparisonResults(Qty o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Qty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Qty", ValidationResult.ValidationType.TYPE_FORMAT, "Qty", path, "", res.getError());
				}
				return success("Qty", ValidationResult.ValidationType.TYPE_FORMAT, "Qty", path, "");
			})
			.collect(toList());
	}

}
