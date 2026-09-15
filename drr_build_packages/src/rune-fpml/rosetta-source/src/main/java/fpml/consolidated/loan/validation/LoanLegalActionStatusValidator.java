package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.LoanLegalActionStatus;
import fpml.consolidated.loan.LoanLegalActionStatusType;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalActionStatusValidator implements Validator<LoanLegalActionStatus> {

	private List<ComparisonResult> getComparisonResults(LoanLegalActionStatus o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("legalActionReference", (LoanLegalActionReference) o.getLegalActionReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LoanLegalActionStatusType) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatus o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalActionStatus", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionStatus", path, "", res.getError());
				}
				return success("LoanLegalActionStatus", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionStatus", path, "");
			})
			.collect(toList());
	}

}
