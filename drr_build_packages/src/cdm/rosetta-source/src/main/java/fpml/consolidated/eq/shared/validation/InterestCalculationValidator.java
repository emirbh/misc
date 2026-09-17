package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.Compounding;
import fpml.consolidated.eq.shared.InterestCalculation;
import fpml.consolidated.fpmlenum.InterpolationPeriodEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.InterpolationMethod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestCalculationValidator implements Validator<InterestCalculation> {

	private List<ComparisonResult> getComparisonResults(InterestCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateCalculation", (FloatingRateCalculation) o.getFloatingRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("compounding", (Compounding) o.getCompounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("interpolationPeriod", (InterpolationPeriodEnum) o.getInterpolationPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestCalculation", ValidationResult.ValidationType.CARDINALITY, "InterestCalculation", path, "", res.getError());
				}
				return success("InterestCalculation", ValidationResult.ValidationType.CARDINALITY, "InterestCalculation", path, "");
			})
			.collect(toList());
	}

}
