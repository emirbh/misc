package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.InterestCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestCalculationTypeFormatValidator implements Validator<InterestCalculation> {

	private List<ComparisonResult> getComparisonResults(InterestCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "InterestCalculation", path, "", res.getError());
				}
				return success("InterestCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "InterestCalculation", path, "");
			})
			.collect(toList());
	}

}
