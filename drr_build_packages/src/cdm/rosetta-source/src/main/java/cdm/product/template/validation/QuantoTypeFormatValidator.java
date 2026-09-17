package cdm.product.template.validation;

import cdm.product.template.Quanto;
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

public class QuantoTypeFormatValidator implements Validator<Quanto> {

	private List<ComparisonResult> getComparisonResults(Quanto o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Quanto o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Quanto", ValidationResult.ValidationType.TYPE_FORMAT, "Quanto", path, "", res.getError());
				}
				return success("Quanto", ValidationResult.ValidationType.TYPE_FORMAT, "Quanto", path, "");
			})
			.collect(toList());
	}

}
