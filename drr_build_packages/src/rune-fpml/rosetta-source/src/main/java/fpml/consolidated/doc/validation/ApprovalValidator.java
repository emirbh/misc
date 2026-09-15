package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.Approval;
import fpml.consolidated.doc.ApprovalId;
import fpml.consolidated.doc.ApprovalType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PersonId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApprovalValidator implements Validator<Approval> {

	private List<ComparisonResult> getComparisonResults(Approval o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (ApprovalType) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("status", (String) o.getStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("approver", (PersonId) o.getApprover() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvingPartyReference", (PartyReference) o.getApprovingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvedPartyReference", (PartyReference) o.getApprovedPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvalId", (ApprovalId) o.getApprovalId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Approval o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Approval", ValidationResult.ValidationType.CARDINALITY, "Approval", path, "", res.getError());
				}
				return success("Approval", ValidationResult.ValidationType.CARDINALITY, "Approval", path, "");
			})
			.collect(toList());
	}

}
