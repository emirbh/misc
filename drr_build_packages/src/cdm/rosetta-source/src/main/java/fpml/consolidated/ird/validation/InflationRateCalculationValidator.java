package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.InflationCalculationMethodEnum;
import fpml.consolidated.fpmlenum.InflationCalculationStyleEnum;
import fpml.consolidated.fpmlenum.NegativeInterestRateTreatmentEnum;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.ird.FinalPrincipalExchangeCalculation;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.MainPublication;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.RateSourcePage;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.Schedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InflationRateCalculationValidator implements Validator<InflationRateCalculation> {

	private List<ComparisonResult> getComparisonResults(InflationRateCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateMultiplierSchedule", (Schedule) o.getFloatingRateMultiplierSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateTreatment", (RateTreatmentEnum) o.getRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialRate", (BigDecimal) o.getInitialRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalRateRounding", (Rounding) o.getFinalRateRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("negativeInterestRateTreatment", (NegativeInterestRateTreatmentEnum) o.getNegativeInterestRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("inflationLag", (Offset) o.getInflationLag() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexSource", (RateSourcePage) o.getIndexSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("mainPublication", (MainPublication) o.getMainPublication() != null ? 1 : 0, 0, 1), 
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialIndexLevel", (BigDecimal) o.getInitialIndexLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackBondApplicable", (Boolean) o.getFallbackBondApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationMethod", (InflationCalculationMethodEnum) o.getCalculationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationStyle", (InflationCalculationStyleEnum) o.getCalculationStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalPrincipalExchangeCalculation", (FinalPrincipalExchangeCalculation) o.getFinalPrincipalExchangeCalculation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationRateCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationRateCalculation", ValidationResult.ValidationType.CARDINALITY, "InflationRateCalculation", path, "", res.getError());
				}
				return success("InflationRateCalculation", ValidationResult.ValidationType.CARDINALITY, "InflationRateCalculation", path, "");
			})
			.collect(toList());
	}

}
