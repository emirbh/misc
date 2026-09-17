package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CollateralAccessBreach;
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

public class CollateralAccessBreachTypeFormatValidator implements Validator<CollateralAccessBreach> {

	private List<ComparisonResult> getComparisonResults(CollateralAccessBreach o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralAccessBreach o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralAccessBreach", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralAccessBreach", path, "", res.getError());
				}
				return success("CollateralAccessBreach", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralAccessBreach", path, "");
			})
			.collect(toList());
	}

}
