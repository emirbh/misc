package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.loan.LoanFloatingRate;
import fpml.consolidated.loan.RateLimits;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Schedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanFloatingRateValidator implements Validator<LoanFloatingRate> {

	private List<ComparisonResult> getComparisonResults(LoanFloatingRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationParameters", (CalculationParameters) o.getCalculationParameters() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackRate", (FallbackRate) o.getFallbackRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateMultiplierSchedule", (Schedule) o.getFloatingRateMultiplierSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateTreatment", (RateTreatmentEnum) o.getRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("isCompoundingBalance", (Boolean) o.getIsCompoundingBalance() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadAdjustment", (BigDecimal) o.getSpreadAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("allInRateLimits", (RateLimits) o.getAllInRateLimits() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanFloatingRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanFloatingRate", ValidationResult.ValidationType.CARDINALITY, "LoanFloatingRate", path, "", res.getError());
				}
				return success("LoanFloatingRate", ValidationResult.ValidationType.CARDINALITY, "LoanFloatingRate", path, "");
			})
			.collect(toList());
	}

}
