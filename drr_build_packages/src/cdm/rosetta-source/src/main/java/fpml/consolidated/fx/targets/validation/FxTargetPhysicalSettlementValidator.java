package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.FxSettlementAdjustmentMethodEnum;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import fpml.consolidated.fx.targets.FxStrike;
import fpml.consolidated.fx.targets.FxStrikeReference;
import fpml.consolidated.fx.targets.FxTargetPhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetPhysicalSettlementValidator implements Validator<FxTargetPhysicalSettlement> {

	private List<ComparisonResult> getComparisonResults(FxTargetPhysicalSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exchangedCurrency1", (FxExchangedCurrency) o.getExchangedCurrency1() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangedCurrency2", (FxExchangedCurrency) o.getExchangedCurrency2() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAdjustmentStyle", (FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle() != null ? 1 : 0, 1, 1), 
				checkCardinality("strike", (FxStrike) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeReference", (FxStrikeReference) o.getStrikeReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetPhysicalSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetPhysicalSettlement", ValidationResult.ValidationType.CARDINALITY, "FxTargetPhysicalSettlement", path, "", res.getError());
				}
				return success("FxTargetPhysicalSettlement", ValidationResult.ValidationType.CARDINALITY, "FxTargetPhysicalSettlement", path, "");
			})
			.collect(toList());
	}

}
