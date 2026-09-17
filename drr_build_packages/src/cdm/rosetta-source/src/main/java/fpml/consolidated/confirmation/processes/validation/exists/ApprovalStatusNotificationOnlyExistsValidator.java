package fpml.consolidated.confirmation.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ApprovalStatusNotification;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApprovalStatusNotificationOnlyExistsValidator implements ValidatorWithArg<ApprovalStatusNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApprovalStatusNotification> ValidationResult<ApprovalStatusNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((NotificationMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("tradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getTradeIdentifier()))
				.put("approvals", ExistenceChecker.isSet((Approvals) o.getApprovals()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.put("account", ExistenceChecker.isSet((List<? extends Account>) o.getAccount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApprovalStatusNotification", ValidationResult.ValidationType.ONLY_EXISTS, "ApprovalStatusNotification", path, "");
		}
		return failure("ApprovalStatusNotification", ValidationResult.ValidationType.ONLY_EXISTS, "ApprovalStatusNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
