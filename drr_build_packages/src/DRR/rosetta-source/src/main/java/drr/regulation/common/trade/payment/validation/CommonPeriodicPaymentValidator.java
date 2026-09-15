package drr.regulation.common.trade.payment.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.IndexEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonPeriodicPaymentValidator implements Validator<CommonPeriodicPayment> {

	private List<ComparisonResult> getComparisonResults(CommonPeriodicPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRateDayCountConvention", (InterestComputationMethod4Code) o.getFixedRateDayCountConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateDayCountConvention", (InterestComputationMethod4Code) o.getFloatingRateDayCountConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRatePaymentFrequencyPeriod", (FrequencyPeriodEnum) o.getFixedRatePaymentFrequencyPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRatePaymentFrequencyPeriod", (FrequencyPeriodEnum) o.getFloatingRatePaymentFrequencyPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRatePaymentFrequencyPeriodMultiplier", (Integer) o.getFixedRatePaymentFrequencyPeriodMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRatePaymentFrequencyPeriodMultiplier", (Integer) o.getFloatingRatePaymentFrequencyPeriodMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateResetFrequencyPeriod", (FrequencyPeriodEnum) o.getFloatingRateResetFrequencyPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateResetFrequencyMultiplier", (Integer) o.getFloatingRateResetFrequencyMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndicator", (IndexEnum) o.getFloatingRateIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIdentifier", (String) o.getFloatingRateIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateReferencePeriod", (FrequencyPeriodEnum) o.getFloatingRateReferencePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateReferencePeriodMultiplier", (Integer) o.getFloatingRateReferencePeriodMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("nameOfTheFloatingRate", (String) o.getNameOfTheFloatingRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonPeriodicPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonPeriodicPayment", ValidationResult.ValidationType.CARDINALITY, "CommonPeriodicPayment", path, "", res.getError());
				}
				return success("CommonPeriodicPayment", ValidationResult.ValidationType.CARDINALITY, "CommonPeriodicPayment", path, "");
			})
			.collect(toList());
	}

}
