package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetKnockoutForwardChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetKnockoutForwardChoiceTypeFormatValidator implements Validator<FxTargetKnockoutForwardChoice> {

	private List<ComparisonResult> getComparisonResults(FxTargetKnockoutForwardChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForwardChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetKnockoutForwardChoice", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetKnockoutForwardChoice", path, "", res.getError());
				}
				return success("FxTargetKnockoutForwardChoice", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetKnockoutForwardChoice", path, "");
			})
			.collect(toList());
	}

}
