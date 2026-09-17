package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.UtilizationAmounts;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class UtilizationAmountsTypeFormatValidator implements Validator<UtilizationAmounts> {

	private List<ComparisonResult> getComparisonResults(UtilizationAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("fundedAmount", o.getFundedAmount(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("unfundedAmount", o.getUnfundedAmount(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UtilizationAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UtilizationAmounts", ValidationResult.ValidationType.TYPE_FORMAT, "UtilizationAmounts", path, "", res.getError());
				}
				return success("UtilizationAmounts", ValidationResult.ValidationType.TYPE_FORMAT, "UtilizationAmounts", path, "");
			})
			.collect(toList());
	}

}
