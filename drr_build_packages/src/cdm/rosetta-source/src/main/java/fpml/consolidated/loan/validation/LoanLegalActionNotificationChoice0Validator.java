package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractFacilityEvent;
import fpml.consolidated.loan.AbstractLcEvent;
import fpml.consolidated.loan.AbstractLoanServicingEvent;
import fpml.consolidated.loan.LoanLegalActionApprovalStatus;
import fpml.consolidated.loan.LoanLegalActionNotificationChoice0;
import fpml.consolidated.loan.LoanLegalActionStatus;
import fpml.consolidated.loan.LoanLegalActionTask;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalActionNotificationChoice0Validator implements Validator<LoanLegalActionNotificationChoice0> {

	private List<ComparisonResult> getComparisonResults(LoanLegalActionNotificationChoice0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityEventGroup", (AbstractFacilityEvent) o.getFacilityEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcEventGroup", (AbstractLcEvent) o.getLcEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanContractEventGroup", (AbstractLoanServicingEvent) o.getLoanContractEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("legalActionTask", (LoanLegalActionTask) o.getLegalActionTask() != null ? 1 : 0, 0, 1), 
				checkCardinality("legalActionStatus", (LoanLegalActionStatus) o.getLegalActionStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("legalActionApprovalStatus", (LoanLegalActionApprovalStatus) o.getLegalActionApprovalStatus() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionNotificationChoice0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalActionNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionNotificationChoice0", path, "", res.getError());
				}
				return success("LoanLegalActionNotificationChoice0", ValidationResult.ValidationType.CARDINALITY, "LoanLegalActionNotificationChoice0", path, "");
			})
			.collect(toList());
	}

}
