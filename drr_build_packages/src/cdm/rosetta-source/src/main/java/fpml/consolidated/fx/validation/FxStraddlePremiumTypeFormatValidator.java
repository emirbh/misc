package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxStraddlePremium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxStraddlePremiumTypeFormatValidator implements Validator<FxStraddlePremium> {

	private List<ComparisonResult> getComparisonResults(FxStraddlePremium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxStraddlePremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxStraddlePremium", ValidationResult.ValidationType.TYPE_FORMAT, "FxStraddlePremium", path, "", res.getError());
				}
				return success("FxStraddlePremium", ValidationResult.ValidationType.TYPE_FORMAT, "FxStraddlePremium", path, "");
			})
			.collect(toList());
	}

}
