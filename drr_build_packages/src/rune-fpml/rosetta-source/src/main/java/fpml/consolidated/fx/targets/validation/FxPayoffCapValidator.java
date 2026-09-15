package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.FxSettlementAdjustmentMethodEnum;
import fpml.consolidated.fx.targets.FxPayoffCap;
import fpml.consolidated.shared.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxPayoffCapValidator implements Validator<FxPayoffCap> {

	private List<ComparisonResult> getComparisonResults(FxPayoffCap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", (ConditionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("rate", (Schedule) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAdjustmentStyle", (FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPayoffCap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPayoffCap", ValidationResult.ValidationType.CARDINALITY, "FxPayoffCap", path, "", res.getError());
				}
				return success("FxPayoffCap", ValidationResult.ValidationType.CARDINALITY, "FxPayoffCap", path, "");
			})
			.collect(toList());
	}

}
