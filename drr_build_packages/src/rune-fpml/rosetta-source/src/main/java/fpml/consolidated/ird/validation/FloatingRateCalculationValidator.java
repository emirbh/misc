package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.NegativeInterestRateTreatmentEnum;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.Schedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingRateCalculationValidator implements Validator<FloatingRateCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingRateCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationParameters", (CalculationParameters) o.getCalculationParameters() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackRate", (FallbackRate) o.getFallbackRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateMultiplierSchedule", (Schedule) o.getFloatingRateMultiplierSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateTreatment", (RateTreatmentEnum) o.getRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialRate", (BigDecimal) o.getInitialRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalRateRounding", (Rounding) o.getFinalRateRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("negativeInterestRateTreatment", (NegativeInterestRateTreatmentEnum) o.getNegativeInterestRateTreatment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateCalculation", ValidationResult.ValidationType.CARDINALITY, "FloatingRateCalculation", path, "", res.getError());
				}
				return success("FloatingRateCalculation", ValidationResult.ValidationType.CARDINALITY, "FloatingRateCalculation", path, "");
			})
			.collect(toList());
	}

}
