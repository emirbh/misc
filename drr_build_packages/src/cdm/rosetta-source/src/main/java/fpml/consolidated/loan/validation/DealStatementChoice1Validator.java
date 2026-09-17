package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.DealStatementChoice1;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.LoanCovenantObligationSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DealStatementChoice1Validator implements Validator<DealStatementChoice1> {

	private List<ComparisonResult> getComparisonResults(DealStatementChoice1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("covenantIdentifier", (CovenantObligationIdentifier) o.getCovenantIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("covenantSummary", (LoanCovenantObligationSummary) o.getCovenantSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("covenant", (LoanCovenantObligation) o.getCovenant() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealStatementChoice1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealStatementChoice1", ValidationResult.ValidationType.CARDINALITY, "DealStatementChoice1", path, "", res.getError());
				}
				return success("DealStatementChoice1", ValidationResult.ValidationType.CARDINALITY, "DealStatementChoice1", path, "");
			})
			.collect(toList());
	}

}
