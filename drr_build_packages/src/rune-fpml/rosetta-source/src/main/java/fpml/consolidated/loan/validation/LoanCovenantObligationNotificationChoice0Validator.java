package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationNotificationChoice0Validator implements Validator<LoanCovenantObligationNotificationChoice0> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationNotificationChoice0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dealIdentifier", (DealIdentifier) o.getDealIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealSummary", (DealSummary) o.getDealSummary() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationNotificationChoice0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationNotificationChoice0", path, "", res.getError());
				}
				return success("LoanCovenantObligationNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationNotificationChoice0", path, "");
			})
			.collect(toList());
	}

}
