package drr.regulation.common.trade.quantity.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.quantity.QuantityFrequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class QuantityFrequencyTypeFormatValidator implements Validator<QuantityFrequency> {

	private List<ComparisonResult> getComparisonResults(QuantityFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), of(3), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuantityFrequency", ValidationResult.ValidationType.TYPE_FORMAT, "QuantityFrequency", path, "", res.getError());
				}
				return success("QuantityFrequency", ValidationResult.ValidationType.TYPE_FORMAT, "QuantityFrequency", path, "");
			})
			.collect(toList());
	}

}
