package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxOptionPremium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxOptionPremiumTypeFormatValidator implements Validator<FxOptionPremium> {

	private List<ComparisonResult> getComparisonResults(FxOptionPremium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOptionPremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOptionPremium", ValidationResult.ValidationType.TYPE_FORMAT, "FxOptionPremium", path, "", res.getError());
				}
				return success("FxOptionPremium", ValidationResult.ValidationType.TYPE_FORMAT, "FxOptionPremium", path, "");
			})
			.collect(toList());
	}

}
