package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.InitialMarginCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InitialMarginCalculationTypeFormatValidator implements Validator<InitialMarginCalculation> {

	private List<ComparisonResult> getComparisonResults(InitialMarginCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialMarginCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InitialMarginCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "InitialMarginCalculation", path, "", res.getError());
				}
				return success("InitialMarginCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "InitialMarginCalculation", path, "");
			})
			.collect(toList());
	}

}
