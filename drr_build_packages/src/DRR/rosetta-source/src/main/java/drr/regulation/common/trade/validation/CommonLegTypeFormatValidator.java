package drr.regulation.common.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.CommonLeg;
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

public class CommonLegTypeFormatValidator implements Validator<CommonLeg> {

	private List<ComparisonResult> getComparisonResults(CommonLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("notionalAmount", o.getNotionalAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("totalNotionalQuantity", o.getTotalNotionalQuantity(), of(25), of(5), empty(), empty()), 
				checkNumber("fixedRate", o.getFixedRate(), of(11), of(10), empty(), empty()), 
				checkString("quantityUnitOfMeasure", o.getQuantityUnitOfMeasure(), 1, of(4), empty()), 
				checkNumber("notionalQuantity", o.getNotionalQuantity(), of(25), of(5), empty(), empty()), 
				checkNumber("quantityFrequencyMultiplier", o.getQuantityFrequencyMultiplier(), of(3), of(0), empty(), empty()), 
				checkString("payerIdentifier", o.getPayerIdentifier(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("receiverIdentifier", o.getReceiverIdentifier(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonLeg", ValidationResult.ValidationType.TYPE_FORMAT, "CommonLeg", path, "", res.getError());
				}
				return success("CommonLeg", ValidationResult.ValidationType.TYPE_FORMAT, "CommonLeg", path, "");
			})
			.collect(toList());
	}

}
