package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.MinimumTransferAmount;
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

public class MinimumTransferAmountTypeFormatValidator implements Validator<MinimumTransferAmount> {

	private List<ComparisonResult> getComparisonResults(MinimumTransferAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MinimumTransferAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MinimumTransferAmount", ValidationResult.ValidationType.TYPE_FORMAT, "MinimumTransferAmount", path, "", res.getError());
				}
				return success("MinimumTransferAmount", ValidationResult.ValidationType.TYPE_FORMAT, "MinimumTransferAmount", path, "");
			})
			.collect(toList());
	}

}
