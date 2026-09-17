package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanFloatingRateOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LoanFloatingRateOptionTypeFormatValidator implements Validator<LoanFloatingRateOption> {

	private List<ComparisonResult> getComparisonResults(LoanFloatingRateOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("drawdownNoticeDays", o.getDrawdownNoticeDays(), empty(), of(0), empty(), empty()), 
				checkNumber("fxRateSetNoticeDays", o.getFxRateSetNoticeDays(), empty(), of(0), empty(), empty()), 
				checkNumber("rateSetNoticeDays", o.getRateSetNoticeDays(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanFloatingRateOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanFloatingRateOption", ValidationResult.ValidationType.TYPE_FORMAT, "LoanFloatingRateOption", path, "", res.getError());
				}
				return success("LoanFloatingRateOption", ValidationResult.ValidationType.TYPE_FORMAT, "LoanFloatingRateOption", path, "");
			})
			.collect(toList());
	}

}
