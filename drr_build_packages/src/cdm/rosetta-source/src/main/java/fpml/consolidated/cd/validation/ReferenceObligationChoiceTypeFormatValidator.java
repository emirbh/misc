package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.ReferenceObligationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceObligationChoiceTypeFormatValidator implements Validator<ReferenceObligationChoice> {

	private List<ComparisonResult> getComparisonResults(ReferenceObligationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceObligationChoice", ValidationResult.ValidationType.TYPE_FORMAT, "ReferenceObligationChoice", path, "", res.getError());
				}
				return success("ReferenceObligationChoice", ValidationResult.ValidationType.TYPE_FORMAT, "ReferenceObligationChoice", path, "");
			})
			.collect(toList());
	}

}
