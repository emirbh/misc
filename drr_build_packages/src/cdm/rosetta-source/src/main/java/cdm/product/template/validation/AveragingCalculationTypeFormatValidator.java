package cdm.product.template.validation;

import cdm.product.template.AveragingCalculation;
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

public class AveragingCalculationTypeFormatValidator implements Validator<AveragingCalculation> {

	private List<ComparisonResult> getComparisonResults(AveragingCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragingCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AveragingCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "AveragingCalculation", path, "", res.getError());
				}
				return success("AveragingCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "AveragingCalculation", path, "");
			})
			.collect(toList());
	}

}
