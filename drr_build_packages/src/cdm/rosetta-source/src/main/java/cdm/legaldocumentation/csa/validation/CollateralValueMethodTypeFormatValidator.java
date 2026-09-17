package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CollateralValueMethod;
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

public class CollateralValueMethodTypeFormatValidator implements Validator<CollateralValueMethod> {

	private List<ComparisonResult> getComparisonResults(CollateralValueMethod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValueMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralValueMethod", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralValueMethod", path, "", res.getError());
				}
				return success("CollateralValueMethod", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralValueMethod", path, "");
			})
			.collect(toList());
	}

}
