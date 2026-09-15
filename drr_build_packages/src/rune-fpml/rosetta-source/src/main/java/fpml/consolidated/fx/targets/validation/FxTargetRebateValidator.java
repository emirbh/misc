package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxOutstandingGain;
import fpml.consolidated.fx.targets.FxTargetRebate;
import fpml.consolidated.shared.SimplePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetRebateValidator implements Validator<FxTargetRebate> {

	private List<ComparisonResult> getComparisonResults(FxTargetRebate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payment", (SimplePayment) o.getPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("outstandingGain", (FxOutstandingGain) o.getOutstandingGain() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRebate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRebate", ValidationResult.ValidationType.CARDINALITY, "FxTargetRebate", path, "", res.getError());
				}
				return success("FxTargetRebate", ValidationResult.ValidationType.CARDINALITY, "FxTargetRebate", path, "");
			})
			.collect(toList());
	}

}
