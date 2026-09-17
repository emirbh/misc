package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.Repayment;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RepaymentTypeFormatValidator implements Validator<Repayment> {

	private List<ComparisonResult> getComparisonResults(Repayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 1, empty(), empty()), 
				checkNumber("price", o.getPrice(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Repayment", ValidationResult.ValidationType.TYPE_FORMAT, "Repayment", path, "", res.getError());
				}
				return success("Repayment", ValidationResult.ValidationType.TYPE_FORMAT, "Repayment", path, "");
			})
			.collect(toList());
	}

}
