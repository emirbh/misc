package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.RelativePriceChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelativePriceChoiceTypeFormatValidator implements Validator<RelativePriceChoice> {

	private List<ComparisonResult> getComparisonResults(RelativePriceChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativePriceChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelativePriceChoice", ValidationResult.ValidationType.TYPE_FORMAT, "RelativePriceChoice", path, "", res.getError());
				}
				return success("RelativePriceChoice", ValidationResult.ValidationType.TYPE_FORMAT, "RelativePriceChoice", path, "");
			})
			.collect(toList());
	}

}
