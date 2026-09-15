package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxOutstandingGain;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxOutstandingGainTypeFormatValidator implements Validator<FxOutstandingGain> {

	private List<ComparisonResult> getComparisonResults(FxOutstandingGain o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOutstandingGain o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOutstandingGain", ValidationResult.ValidationType.TYPE_FORMAT, "FxOutstandingGain", path, "", res.getError());
				}
				return success("FxOutstandingGain", ValidationResult.ValidationType.TYPE_FORMAT, "FxOutstandingGain", path, "");
			})
			.collect(toList());
	}

}
