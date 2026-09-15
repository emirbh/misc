package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradingCostOfCarry;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingCostOfCarryTypeFormatValidator implements Validator<LoanTradingCostOfCarry> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCostOfCarry o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCostOfCarry o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCostOfCarry", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarry", path, "", res.getError());
				}
				return success("LoanTradingCostOfCarry", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarry", path, "");
			})
			.collect(toList());
	}

}
