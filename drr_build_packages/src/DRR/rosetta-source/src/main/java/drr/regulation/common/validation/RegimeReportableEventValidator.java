package drr.regulation.common.validation;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.RegimeReportableEvent;
import drr.regulation.common.ReportableInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegimeReportableEventValidator implements Validator<RegimeReportableEvent> {

	private List<ComparisonResult> getComparisonResults(RegimeReportableEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originatingWorkflowStep", (WorkflowStep) o.getOriginatingWorkflowStep() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportableTrade", (TradeState) o.getReportableTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportablePosition", (CounterpartyPositionState) o.getReportablePosition() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportableInformation", (ReportableInformation) o.getReportableInformation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegimeReportableEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegimeReportableEvent", ValidationResult.ValidationType.CARDINALITY, "RegimeReportableEvent", path, "", res.getError());
				}
				return success("RegimeReportableEvent", ValidationResult.ValidationType.CARDINALITY, "RegimeReportableEvent", path, "");
			})
			.collect(toList());
	}

}
