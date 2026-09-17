package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodLeverageValidator implements Validator<SettlementPeriodLeverage> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodLeverage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ratio", (BigDecimal) o.getRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterCurrencyAmount", (BigDecimal) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodLeverage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodLeverage", ValidationResult.ValidationType.CARDINALITY, "SettlementPeriodLeverage", path, "", res.getError());
				}
				return success("SettlementPeriodLeverage", ValidationResult.ValidationType.CARDINALITY, "SettlementPeriodLeverage", path, "");
			})
			.collect(toList());
	}

}
