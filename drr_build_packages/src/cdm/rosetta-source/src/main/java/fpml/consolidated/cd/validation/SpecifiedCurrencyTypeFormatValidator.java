package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.SpecifiedCurrency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SpecifiedCurrencyTypeFormatValidator implements Validator<SpecifiedCurrency> {

	private List<ComparisonResult> getComparisonResults(SpecifiedCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecifiedCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpecifiedCurrency", ValidationResult.ValidationType.TYPE_FORMAT, "SpecifiedCurrency", path, "", res.getError());
				}
				return success("SpecifiedCurrency", ValidationResult.ValidationType.TYPE_FORMAT, "SpecifiedCurrency", path, "");
			})
			.collect(toList());
	}

}
