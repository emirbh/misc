package drr.base.margin.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.margin.CollateralDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralDetailsTypeFormatValidator implements Validator<CollateralDetails> {

	private List<ComparisonResult> getComparisonResults(CollateralDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralDetails", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralDetails", path, "", res.getError());
				}
				return success("CollateralDetails", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralDetails", path, "");
			})
			.collect(toList());
	}

}
