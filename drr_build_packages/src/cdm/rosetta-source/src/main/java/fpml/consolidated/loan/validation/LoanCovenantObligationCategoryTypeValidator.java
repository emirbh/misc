package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationCategoryType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationCategoryTypeValidator implements Validator<LoanCovenantObligationCategoryType> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationCategoryType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanCovenantObligationCategoryTypeScheme", (String) o.getLoanCovenantObligationCategoryTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationCategoryType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationCategoryType", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationCategoryType", path, "", res.getError());
				}
				return success("LoanCovenantObligationCategoryType", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationCategoryType", path, "");
			})
			.collect(toList());
	}

}
