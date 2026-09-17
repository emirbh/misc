package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetConstantPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetKnockoutForwardChoice;
import fpml.consolidated.fx.targets.FxTargetLinearPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetKnockoutForwardChoiceValidator implements Validator<FxTargetKnockoutForwardChoice> {

	private List<ComparisonResult> getComparisonResults(FxTargetKnockoutForwardChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("constantPayoffRegion", (FxTargetConstantPayoffRegion) o.getConstantPayoffRegion() != null ? 1 : 0, 0, 1), 
				checkCardinality("linearPayoffRegion", (FxTargetLinearPayoffRegion) o.getLinearPayoffRegion() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForwardChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetKnockoutForwardChoice", ValidationResult.ValidationType.CARDINALITY, "FxTargetKnockoutForwardChoice", path, "", res.getError());
				}
				return success("FxTargetKnockoutForwardChoice", ValidationResult.ValidationType.CARDINALITY, "FxTargetKnockoutForwardChoice", path, "");
			})
			.collect(toList());
	}

}
