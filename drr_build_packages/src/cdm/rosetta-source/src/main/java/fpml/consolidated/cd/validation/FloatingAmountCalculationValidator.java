package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.cd.FloatingAmountCalculation;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.DayCountFraction;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingAmountCalculationValidator implements Validator<FloatingAmountCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingAmountCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationAmount", (CalculationAmount) o.getCalculationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRate", (FloatingRateCalculation) o.getFloatingRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFixingDate", (ZonedDateTime) o.getInitialFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalFixingDate", (AdjustableDate) o.getFinalFixingDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingAmountCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingAmountCalculation", ValidationResult.ValidationType.CARDINALITY, "FloatingAmountCalculation", path, "", res.getError());
				}
				return success("FloatingAmountCalculation", ValidationResult.ValidationType.CARDINALITY, "FloatingAmountCalculation", path, "");
			})
			.collect(toList());
	}

}
