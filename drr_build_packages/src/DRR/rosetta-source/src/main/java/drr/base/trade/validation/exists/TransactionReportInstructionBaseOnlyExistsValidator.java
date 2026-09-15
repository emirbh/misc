package drr.base.trade.validation.exists;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportingSide;
import drr.base.trade.TransactionReportInstructionBase;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TransactionReportInstructionBaseOnlyExistsValidator implements ValidatorWithArg<TransactionReportInstructionBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TransactionReportInstructionBase> ValidationResult<TransactionReportInstructionBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("originatingWorkflowStep", ExistenceChecker.isSet((WorkflowStep) o.getOriginatingWorkflowStep()))
				.put("reportableTrade", ExistenceChecker.isSet((TradeState) o.getReportableTrade()))
				.put("reportablePosition", ExistenceChecker.isSet((CounterpartyPositionState) o.getReportablePosition()))
				.put("reportableInformation", ExistenceChecker.isSet((ReportableInformationBase) o.getReportableInformation()))
				.put("reportingSide", ExistenceChecker.isSet((ReportingSide) o.getReportingSide()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TransactionReportInstructionBase", ValidationResult.ValidationType.ONLY_EXISTS, "TransactionReportInstructionBase", path, "");
		}
		return failure("TransactionReportInstructionBase", ValidationResult.ValidationType.ONLY_EXISTS, "TransactionReportInstructionBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
