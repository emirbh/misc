package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetails;
import fpml.consolidated.loan.LoanCovenantObligationHybridDetails;
import fpml.consolidated.loan.LoanCovenantObligationMetric;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationHybridDetailsValidator implements Validator<LoanCovenantObligationHybridDetails> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationHybridDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (List<? extends LoanCovenantObligationDateTriggerDetails>) o.getDate() == null ? 0 : o.getDate().size(), 1, 0), 
				checkCardinality("metric", (LoanCovenantObligationMetric) o.getMetric() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationHybridDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationHybridDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationHybridDetails", path, "", res.getError());
				}
				return success("LoanCovenantObligationHybridDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationHybridDetails", path, "");
			})
			.collect(toList());
	}

}
