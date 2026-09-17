package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.TaskStatusEnum;
import fpml.consolidated.loan.LoanAllocationReference;
import fpml.consolidated.loan.LoanAllocationSettlementTask;
import fpml.consolidated.loan.LoanAllocationSettlementTaskType;
import fpml.consolidated.loan.ParentTaskIdentifier;
import fpml.consolidated.loan.TaskDates;
import fpml.consolidated.loan.TaskIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationSettlementTaskValidator implements Validator<LoanAllocationSettlementTask> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationSettlementTask o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("taskIdentifier", (List<? extends TaskIdentifier>) o.getTaskIdentifier() == null ? 0 : o.getTaskIdentifier().size(), 1, 0), 
				checkCardinality("parentTaskIdentifier", (ParentTaskIdentifier) o.getParentTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("previousTaskIdentifier", (TaskIdentifier) o.getPreviousTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedTaskIdentifier", (TaskIdentifier) o.getCorrectedTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("responsibleParty", (PartyReference) o.getResponsibleParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("dates", (TaskDates) o.getDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("status", (TaskStatusEnum) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationReference", (List<? extends LoanAllocationReference>) o.getAllocationReference() == null ? 0 : o.getAllocationReference().size(), 1, 0), 
				checkCardinality("type", (LoanAllocationSettlementTaskType) o._getType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementTask o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationSettlementTask", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationSettlementTask", path, "", res.getError());
				}
				return success("LoanAllocationSettlementTask", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationSettlementTask", path, "");
			})
			.collect(toList());
	}

}
