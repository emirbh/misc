package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ResetCalculationPeriod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ResetCalculationPeriodTypeFormatValidator implements Validator<ResetCalculationPeriod> {

	private List<ComparisonResult> getComparisonResults(ResetCalculationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("numberOfDays", o.getNumberOfDays(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetCalculationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResetCalculationPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "ResetCalculationPeriod", path, "", res.getError());
				}
				return success("ResetCalculationPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "ResetCalculationPeriod", path, "");
			})
			.collect(toList());
	}

}
