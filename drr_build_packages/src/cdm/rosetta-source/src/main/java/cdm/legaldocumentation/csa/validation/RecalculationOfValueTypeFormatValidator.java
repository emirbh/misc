package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.RecalculationOfValue;
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

public class RecalculationOfValueTypeFormatValidator implements Validator<RecalculationOfValue> {

	private List<ComparisonResult> getComparisonResults(RecalculationOfValue o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RecalculationOfValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RecalculationOfValue", ValidationResult.ValidationType.TYPE_FORMAT, "RecalculationOfValue", path, "", res.getError());
				}
				return success("RecalculationOfValue", ValidationResult.ValidationType.TYPE_FORMAT, "RecalculationOfValue", path, "");
			})
			.collect(toList());
	}

}
