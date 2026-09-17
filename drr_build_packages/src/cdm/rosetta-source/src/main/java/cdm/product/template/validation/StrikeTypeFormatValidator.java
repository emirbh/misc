package cdm.product.template.validation;

import cdm.product.template.Strike;
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

public class StrikeTypeFormatValidator implements Validator<Strike> {

	private List<ComparisonResult> getComparisonResults(Strike o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Strike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Strike", ValidationResult.ValidationType.TYPE_FORMAT, "Strike", path, "", res.getError());
				}
				return success("Strike", ValidationResult.ValidationType.TYPE_FORMAT, "Strike", path, "");
			})
			.collect(toList());
	}

}
