package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.ComputedAmount;
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

public class ComputedAmountTypeFormatValidator implements Validator<ComputedAmount> {

	private List<ComparisonResult> getComparisonResults(ComputedAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ComputedAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ComputedAmount", ValidationResult.ValidationType.TYPE_FORMAT, "ComputedAmount", path, "", res.getError());
				}
				return success("ComputedAmount", ValidationResult.ValidationType.TYPE_FORMAT, "ComputedAmount", path, "");
			})
			.collect(toList());
	}

}
