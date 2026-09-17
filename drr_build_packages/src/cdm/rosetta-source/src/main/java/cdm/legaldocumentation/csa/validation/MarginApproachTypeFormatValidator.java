package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.MarginApproach;
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

public class MarginApproachTypeFormatValidator implements Validator<MarginApproach> {

	private List<ComparisonResult> getComparisonResults(MarginApproach o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginApproach o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginApproach", ValidationResult.ValidationType.TYPE_FORMAT, "MarginApproach", path, "", res.getError());
				}
				return success("MarginApproach", ValidationResult.ValidationType.TYPE_FORMAT, "MarginApproach", path, "");
			})
			.collect(toList());
	}

}
