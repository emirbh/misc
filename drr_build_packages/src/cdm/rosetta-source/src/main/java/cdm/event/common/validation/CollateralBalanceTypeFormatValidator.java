package cdm.event.common.validation;

import cdm.event.common.CollateralBalance;
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

public class CollateralBalanceTypeFormatValidator implements Validator<CollateralBalance> {

	private List<ComparisonResult> getComparisonResults(CollateralBalance o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralBalance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralBalance", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralBalance", path, "", res.getError());
				}
				return success("CollateralBalance", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralBalance", path, "");
			})
			.collect(toList());
	}

}
