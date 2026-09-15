package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.FxStraddleTypeEnum;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.fx.FxStraddle;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxStraddleValidator implements Validator<FxStraddle> {

	private List<ComparisonResult> getComparisonResults(FxStraddle o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("straddleType", (FxStraddleTypeEnum) o.getStraddleType() != null ? 1 : 0, 1, 1), 
				checkCardinality("tenorPeriod", (Period) o.getTenorPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("europeanExercise", (FxEuropeanExercise) o.getEuropeanExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("notional", (NonNegativeMoney) o.getNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrency", (Currency) o.getCounterCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (AdjustableOrAdjustedDate) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (FxCashSettlementSimple) o.getCashSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxStraddle o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxStraddle", ValidationResult.ValidationType.CARDINALITY, "FxStraddle", path, "", res.getError());
				}
				return success("FxStraddle", ValidationResult.ValidationType.CARDINALITY, "FxStraddle", path, "");
			})
			.collect(toList());
	}

}
