package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionDetails;
import fpml.consolidated.loan.LoanLegalActionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalActionDetailsValidator implements Validator<LoanLegalActionDetails> {

	private List<ComparisonResult> getComparisonResults(LoanLegalActionDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("legalActionType", (LoanLegalActionType) o.getLegalActionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalActionDetails", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionDetails", path, "", res.getError());
				}
				return success("LoanLegalActionDetails", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionDetails", path, "");
			})
			.collect(toList());
	}

}
