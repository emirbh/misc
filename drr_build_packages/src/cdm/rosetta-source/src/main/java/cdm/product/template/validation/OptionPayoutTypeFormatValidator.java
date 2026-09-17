package cdm.product.template.validation;

import cdm.product.template.OptionPayout;
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

public class OptionPayoutTypeFormatValidator implements Validator<OptionPayout> {

	private List<ComparisonResult> getComparisonResults(OptionPayout o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionPayout", ValidationResult.ValidationType.TYPE_FORMAT, "OptionPayout", path, "", res.getError());
				}
				return success("OptionPayout", ValidationResult.ValidationType.TYPE_FORMAT, "OptionPayout", path, "");
			})
			.collect(toList());
	}

}
