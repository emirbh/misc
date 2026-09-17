package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.TaskStatusEnum;
import fpml.consolidated.loan.LoanTradeReference;
import fpml.consolidated.loan.LoanTradeSettlementTask;
import fpml.consolidated.loan.LoanTradeSettlementTaskType;
import fpml.consolidated.loan.ParentTaskIdentifier;
import fpml.consolidated.loan.TaskDates;
import fpml.consolidated.loan.TaskIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradeSettlementTaskOnlyExistsValidator implements ValidatorWithArg<LoanTradeSettlementTask, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradeSettlementTask> ValidationResult<LoanTradeSettlementTask> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("taskIdentifier", ExistenceChecker.isSet((List<? extends TaskIdentifier>) o.getTaskIdentifier()))
				.put("parentTaskIdentifier", ExistenceChecker.isSet((ParentTaskIdentifier) o.getParentTaskIdentifier()))
				.put("previousTaskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getPreviousTaskIdentifier()))
				.put("correctedTaskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getCorrectedTaskIdentifier()))
				.put("responsibleParty", ExistenceChecker.isSet((PartyReference) o.getResponsibleParty()))
				.put("dates", ExistenceChecker.isSet((TaskDates) o.getDates()))
				.put("status", ExistenceChecker.isSet((TaskStatusEnum) o.getStatus()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("loanTradeReference", ExistenceChecker.isSet((LoanTradeReference) o.getLoanTradeReference()))
				.put("type", ExistenceChecker.isSet((LoanTradeSettlementTaskType) o._getType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradeSettlementTask", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradeSettlementTask", path, "");
		}
		return failure("LoanTradeSettlementTask", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradeSettlementTask", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
