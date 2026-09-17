package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.accruals.FxAccrualAverageStrikeReference;
import fpml.consolidated.fx.accruals.FxAccrualLeverage;
import fpml.consolidated.fx.accruals.FxAccrualStrikeReference;
import fpml.consolidated.fx.accruals.FxAccrualTriggerReference;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.FxLevel;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualLeverageValidator implements Validator<FxAccrualLeverage> {

	private List<ComparisonResult> getComparisonResults(FxAccrualLeverage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("condition", (ConditionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("level", (FxLevel) o.getLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("quoteBasis", (QuoteBasisEnum) o.getQuoteBasis() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeReference", (FxAccrualStrikeReference) o.getStrikeReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageStrikeReference", (FxAccrualAverageStrikeReference) o.getAverageStrikeReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerReference", (FxAccrualTriggerReference) o.getTriggerReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("ratio", (Schedule) o.getRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterCurrencyAmount", (FxCounterCurrencyAmount) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLeverage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualLeverage", ValidationResult.ValidationType.CARDINALITY, "FxAccrualLeverage", path, "", res.getError());
				}
				return success("FxAccrualLeverage", ValidationResult.ValidationType.CARDINALITY, "FxAccrualLeverage", path, "");
			})
			.collect(toList());
	}

}
