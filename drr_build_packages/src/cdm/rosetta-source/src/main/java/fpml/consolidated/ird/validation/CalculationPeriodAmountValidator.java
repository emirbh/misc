package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.shared.AmountSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationPeriodAmountValidator implements Validator<CalculationPeriodAmount> {

	private List<ComparisonResult> getComparisonResults(CalculationPeriodAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculation", (Calculation) o.getCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("knownAmountSchedule", (AmountSchedule) o.getKnownAmountSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationPeriodAmount", ValidationResult.ValidationType.CARDINALITY, "CalculationPeriodAmount", path, "", res.getError());
				}
				return success("CalculationPeriodAmount", ValidationResult.ValidationType.CARDINALITY, "CalculationPeriodAmount", path, "");
			})
			.collect(toList());
	}

}
