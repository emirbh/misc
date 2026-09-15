package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.EquityAccumulator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class EquityAccumulatorTypeFormatValidator implements Validator<EquityAccumulator> {

	private List<ComparisonResult> getComparisonResults(EquityAccumulator o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("numberOfSharesPerDay", o.getNumberOfSharesPerDay(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("maxNoOfTradingDays", o.getMaxNoOfTradingDays(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityAccumulator o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityAccumulator", ValidationResult.ValidationType.TYPE_FORMAT, "EquityAccumulator", path, "", res.getError());
				}
				return success("EquityAccumulator", ValidationResult.ValidationType.TYPE_FORMAT, "EquityAccumulator", path, "");
			})
			.collect(toList());
	}

}
