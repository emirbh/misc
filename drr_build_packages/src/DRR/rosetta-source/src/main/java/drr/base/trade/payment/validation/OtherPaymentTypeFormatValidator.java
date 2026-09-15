package drr.base.trade.payment.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
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

public class OtherPaymentTypeFormatValidator implements Validator<OtherPayment> {

	private List<ComparisonResult> getComparisonResults(OtherPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("amount", o.getAmount(), of(25), of(5), empty(), empty()), 
				checkString("payer", o.getPayer(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("receiver", o.getReceiver(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherPayment", ValidationResult.ValidationType.TYPE_FORMAT, "OtherPayment", path, "", res.getError());
				}
				return success("OtherPayment", ValidationResult.ValidationType.TYPE_FORMAT, "OtherPayment", path, "");
			})
			.collect(toList());
	}

}
