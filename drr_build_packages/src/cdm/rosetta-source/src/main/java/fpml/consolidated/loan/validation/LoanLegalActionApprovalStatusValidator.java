package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalVotes;
import fpml.consolidated.loan.LoanLegalActionApprovalStatus;
import fpml.consolidated.loan.LoanLegalActionApprovalStatusType;
import fpml.consolidated.loan.LoanLegalActionReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalActionApprovalStatusValidator implements Validator<LoanLegalActionApprovalStatus> {

	private List<ComparisonResult> getComparisonResults(LoanLegalActionApprovalStatus o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvalVotes", (ApprovalVotes) o.getApprovalVotes() != null ? 1 : 0, 1, 1), 
				checkCardinality("finalApprovalDate", (ZonedDateTime) o.getFinalApprovalDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("legalActionReference", (LoanLegalActionReference) o.getLegalActionReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LoanLegalActionApprovalStatusType) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionApprovalStatus o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalActionApprovalStatus", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionApprovalStatus", path, "", res.getError());
				}
				return success("LoanLegalActionApprovalStatus", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionApprovalStatus", path, "");
			})
			.collect(toList());
	}

}
