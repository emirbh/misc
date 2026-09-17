package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.LoanNotificationException;
import fpml.consolidated.loan.TaskIdentifier;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.shared.Party;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanNotificationExceptionOnlyExistsValidator implements ValidatorWithArg<LoanNotificationException, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanNotificationException> ValidationResult<LoanNotificationException> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((ExceptionMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("reason", ExistenceChecker.isSet((List<? extends Reason>) o.getReason()))
				.put("additionalData", ExistenceChecker.isSet((AdditionalData) o.getAdditionalData()))
				.put("eventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getEventIdentifier()))
				.put("taskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getTaskIdentifier()))
				.put("party", ExistenceChecker.isSet((Party) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanNotificationException", ValidationResult.ValidationType.ONLY_EXISTS, "LoanNotificationException", path, "");
		}
		return failure("LoanNotificationException", ValidationResult.ValidationType.ONLY_EXISTS, "LoanNotificationException", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
