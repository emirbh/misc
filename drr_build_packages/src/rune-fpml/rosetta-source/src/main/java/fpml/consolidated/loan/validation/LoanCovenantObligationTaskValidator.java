package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.TaskStatusEnum;
import fpml.consolidated.loan.LoanCovenantObligationReference;
import fpml.consolidated.loan.LoanCovenantObligationTask;
import fpml.consolidated.loan.LoanCovenantObligationTaskType;
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

public class LoanCovenantObligationTaskValidator implements Validator<LoanCovenantObligationTask> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationTask o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("taskIdentifier", (List<? extends TaskIdentifier>) o.getTaskIdentifier() == null ? 0 : o.getTaskIdentifier().size(), 1, 0), 
				checkCardinality("parentTaskIdentifier", (ParentTaskIdentifier) o.getParentTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("previousTaskIdentifier", (TaskIdentifier) o.getPreviousTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedTaskIdentifier", (TaskIdentifier) o.getCorrectedTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("responsibleParty", (PartyReference) o.getResponsibleParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("dates", (TaskDates) o.getDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("status", (TaskStatusEnum) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("covenantReference", (LoanCovenantObligationReference) o.getCovenantReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LoanCovenantObligationTaskType) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationTask o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationTask", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationTask", path, "", res.getError());
				}
				return success("LoanCovenantObligationTask", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationTask", path, "");
			})
			.collect(toList());
	}

}
