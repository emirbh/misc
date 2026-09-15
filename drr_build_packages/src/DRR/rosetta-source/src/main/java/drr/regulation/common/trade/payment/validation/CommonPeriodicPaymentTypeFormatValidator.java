package drr.regulation.common.trade.payment.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CommonPeriodicPaymentTypeFormatValidator implements Validator<CommonPeriodicPayment> {

	private List<ComparisonResult> getComparisonResults(CommonPeriodicPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("fixedRatePaymentFrequencyPeriodMultiplier", o.getFixedRatePaymentFrequencyPeriodMultiplier(), of(3), of(0), empty(), empty()), 
				checkNumber("floatingRatePaymentFrequencyPeriodMultiplier", o.getFloatingRatePaymentFrequencyPeriodMultiplier(), of(3), of(0), empty(), empty()), 
				checkNumber("floatingRateResetFrequencyMultiplier", o.getFloatingRateResetFrequencyMultiplier(), of(3), of(0), empty(), empty()), 
				checkString("floatingRateIdentifier", o.getFloatingRateIdentifier(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}[A-Z0-9]{9,9}[0-9]{1,1}"))), 
				checkNumber("floatingRateReferencePeriodMultiplier", o.getFloatingRateReferencePeriodMultiplier(), of(3), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonPeriodicPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonPeriodicPayment", ValidationResult.ValidationType.TYPE_FORMAT, "CommonPeriodicPayment", path, "", res.getError());
				}
				return success("CommonPeriodicPayment", ValidationResult.ValidationType.TYPE_FORMAT, "CommonPeriodicPayment", path, "");
			})
			.collect(toList());
	}

}
