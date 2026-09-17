package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FutureValueAmount;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FutureValueAmountTypeFormatValidator implements Validator<FutureValueAmount> {

	private List<ComparisonResult> getComparisonResults(FutureValueAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("amount", o.getAmount(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("calculationPeriodNumberOfDays", o.getCalculationPeriodNumberOfDays(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FutureValueAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FutureValueAmount", ValidationResult.ValidationType.TYPE_FORMAT, "FutureValueAmount", path, "", res.getError());
				}
				return success("FutureValueAmount", ValidationResult.ValidationType.TYPE_FORMAT, "FutureValueAmount", path, "");
			})
			.collect(toList());
	}

}
