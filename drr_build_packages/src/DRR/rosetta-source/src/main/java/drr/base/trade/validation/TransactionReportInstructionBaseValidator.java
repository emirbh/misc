package drr.base.trade.validation;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportingSide;
import drr.base.trade.TransactionReportInstructionBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TransactionReportInstructionBaseValidator implements Validator<TransactionReportInstructionBase> {

	private List<ComparisonResult> getComparisonResults(TransactionReportInstructionBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originatingWorkflowStep", (WorkflowStep) o.getOriginatingWorkflowStep() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportableTrade", (TradeState) o.getReportableTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportablePosition", (CounterpartyPositionState) o.getReportablePosition() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportableInformation", (ReportableInformationBase) o.getReportableInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingSide", (ReportingSide) o.getReportingSide() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactionReportInstructionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactionReportInstructionBase", ValidationResult.ValidationType.CARDINALITY, "TransactionReportInstructionBase", path, "", res.getError());
				}
				return success("TransactionReportInstructionBase", ValidationResult.ValidationType.CARDINALITY, "TransactionReportInstructionBase", path, "");
			})
			.collect(toList());
	}

}
