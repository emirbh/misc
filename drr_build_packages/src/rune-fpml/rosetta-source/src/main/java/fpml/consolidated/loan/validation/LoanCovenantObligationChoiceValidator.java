package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationChoiceValidator implements Validator<LoanCovenantObligationChoice> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("location", (String) o.getLocation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationChoice", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationChoice", path, "", res.getError());
				}
				return success("LoanCovenantObligationChoice", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationChoice", path, "");
			})
			.collect(toList());
	}

}
