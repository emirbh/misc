package drr.base.trade.quantity.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class NotionalPeriodTypeFormatValidator implements Validator<NotionalPeriod> {

	private List<ComparisonResult> getComparisonResults(NotionalPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("value", o.getValue(), of(25), of(5), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalPeriod", path, "", res.getError());
				}
				return success("NotionalPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalPeriod", path, "");
			})
			.collect(toList());
	}

}
