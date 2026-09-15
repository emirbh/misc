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
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UtilizationAmountsValidator implements Validator<UtilizationAmounts> {

	private List<ComparisonResult> getComparisonResults(UtilizationAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fundedAmount", (BigDecimal) o.getFundedAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("unfundedAmount", (BigDecimal) o.getUnfundedAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UtilizationAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UtilizationAmounts", ValidationResult.ValidationType.CARDINALITY, "UtilizationAmounts", path, "", res.getError());
				}
				return success("UtilizationAmounts", ValidationResult.ValidationType.CARDINALITY, "UtilizationAmounts", path, "");
			})
			.collect(toList());
	}

}
