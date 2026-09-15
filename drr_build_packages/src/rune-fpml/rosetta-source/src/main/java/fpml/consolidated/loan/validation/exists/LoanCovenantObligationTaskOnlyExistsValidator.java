package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.TaskStatusEnum;
import fpml.consolidated.loan.LoanCovenantObligationReference;
import fpml.consolidated.loan.LoanCovenantObligationTask;
import fpml.consolidated.loan.LoanCovenantObligationTaskType;
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

public class LoanCovenantObligationTaskOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationTask, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationTask> ValidationResult<LoanCovenantObligationTask> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("taskIdentifier", ExistenceChecker.isSet((List<? extends TaskIdentifier>) o.getTaskIdentifier()))
				.put("parentTaskIdentifier", ExistenceChecker.isSet((ParentTaskIdentifier) o.getParentTaskIdentifier()))
				.put("previousTaskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getPreviousTaskIdentifier()))
				.put("correctedTaskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getCorrectedTaskIdentifier()))
				.put("responsibleParty", ExistenceChecker.isSet((PartyReference) o.getResponsibleParty()))
				.put("dates", ExistenceChecker.isSet((TaskDates) o.getDates()))
				.put("status", ExistenceChecker.isSet((TaskStatusEnum) o.getStatus()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("covenantReference", ExistenceChecker.isSet((LoanCovenantObligationReference) o.getCovenantReference()))
				.put("type", ExistenceChecker.isSet((LoanCovenantObligationTaskType) o._getType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationTask", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationTask", path, "");
		}
		return failure("LoanCovenantObligationTask", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationTask", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
