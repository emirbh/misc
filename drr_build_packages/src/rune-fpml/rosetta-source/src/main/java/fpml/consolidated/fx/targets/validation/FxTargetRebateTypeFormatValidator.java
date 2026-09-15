package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetRebate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetRebateTypeFormatValidator implements Validator<FxTargetRebate> {

	private List<ComparisonResult> getComparisonResults(FxTargetRebate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRebate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRebate", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetRebate", path, "", res.getError());
				}
				return success("FxTargetRebate", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetRebate", path, "");
			})
			.collect(toList());
	}

}
