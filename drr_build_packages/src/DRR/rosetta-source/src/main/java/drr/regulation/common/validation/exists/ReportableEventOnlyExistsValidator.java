package drr.regulation.common.validation.exists;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportableEventOnlyExistsValidator implements ValidatorWithArg<ReportableEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportableEvent> ValidationResult<ReportableEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("originatingWorkflowStep", ExistenceChecker.isSet((WorkflowStep) o.getOriginatingWorkflowStep()))
				.put("reportableTrade", ExistenceChecker.isSet((TradeState) o.getReportableTrade()))
				.put("reportablePosition", ExistenceChecker.isSet((CounterpartyPositionState) o.getReportablePosition()))
				.put("reportableInformation", ExistenceChecker.isSet((ReportableInformation) o.getReportableInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportableEvent", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableEvent", path, "");
		}
		return failure("ReportableEvent", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
