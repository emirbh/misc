package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxExchangedCurrencyTypeFormatValidator implements Validator<FxExchangedCurrency> {

	private List<ComparisonResult> getComparisonResults(FxExchangedCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExchangedCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExchangedCurrency", ValidationResult.ValidationType.TYPE_FORMAT, "FxExchangedCurrency", path, "", res.getError());
				}
				return success("FxExchangedCurrency", ValidationResult.ValidationType.TYPE_FORMAT, "FxExchangedCurrency", path, "");
			})
			.collect(toList());
	}

}
