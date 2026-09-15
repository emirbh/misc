package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.FxSettlementAdjustmentMethodEnum;
import fpml.consolidated.fx.targets.FxOutstandingGain;
import fpml.consolidated.fx.targets.FxTargetReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxOutstandingGainValidator implements Validator<FxOutstandingGain> {

	private List<ComparisonResult> getComparisonResults(FxOutstandingGain o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("targetReference", (FxTargetReference) o.getTargetReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAdjustmentStyle", (FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOutstandingGain o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOutstandingGain", ValidationResult.ValidationType.CARDINALITY, "FxOutstandingGain", path, "", res.getError());
				}
				return success("FxOutstandingGain", ValidationResult.ValidationType.CARDINALITY, "FxOutstandingGain", path, "");
			})
			.collect(toList());
	}

}
