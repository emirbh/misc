package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.NegativeInterestRateTreatmentEnum;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.InflationRateCalculationBase;
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

public class InflationRateCalculationBaseValidator implements Validator<InflationRateCalculationBase> {

	private List<ComparisonResult> getComparisonResults(InflationRateCalculationBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateMultiplierSchedule", (Schedule) o.getFloatingRateMultiplierSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateTreatment", (RateTreatmentEnum) o.getRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialRate", (BigDecimal) o.getInitialRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalRateRounding", (Rounding) o.getFinalRateRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("negativeInterestRateTreatment", (NegativeInterestRateTreatmentEnum) o.getNegativeInterestRateTreatment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationRateCalculationBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationRateCalculationBase", ValidationResult.ValidationType.CARDINALITY, "InflationRateCalculationBase", path, "", res.getError());
				}
				return success("InflationRateCalculationBase", ValidationResult.ValidationType.CARDINALITY, "InflationRateCalculationBase", path, "");
			})
			.collect(toList());
	}

}
