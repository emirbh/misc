package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CSAThreshold;
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

public class CSAThresholdTypeFormatValidator implements Validator<CSAThreshold> {

	private List<ComparisonResult> getComparisonResults(CSAThreshold o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAThreshold o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSAThreshold", ValidationResult.ValidationType.TYPE_FORMAT, "CSAThreshold", path, "", res.getError());
				}
				return success("CSAThreshold", ValidationResult.ValidationType.TYPE_FORMAT, "CSAThreshold", path, "");
			})
			.collect(toList());
	}

}
