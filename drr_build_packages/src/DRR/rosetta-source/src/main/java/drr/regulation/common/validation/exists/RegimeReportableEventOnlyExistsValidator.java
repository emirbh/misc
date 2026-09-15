package drr.regulation.common.validation.exists;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.RegimeReportableEvent;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.ReportableInformation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegimeReportableEventOnlyExistsValidator implements ValidatorWithArg<RegimeReportableEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegimeReportableEvent> ValidationResult<RegimeReportableEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("originatingWorkflowStep", ExistenceChecker.isSet((WorkflowStep) o.getOriginatingWorkflowStep()))
				.put("reportableTrade", ExistenceChecker.isSet((TradeState) o.getReportableTrade()))
				.put("reportablePosition", ExistenceChecker.isSet((CounterpartyPositionState) o.getReportablePosition()))
				.put("reportableInformation", ExistenceChecker.isSet((ReportableInformation) o.getReportableInformation()))
				.put("regimeReportingSide", ExistenceChecker.isSet((List<? extends RegimeReportingSide>) o.getRegimeReportingSide()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegimeReportableEvent", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeReportableEvent", path, "");
		}
		return failure("RegimeReportableEvent", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeReportableEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
