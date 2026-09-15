package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.RequestedWithdrawalAction;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.business.events.WithdrawalReason;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.Trade;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WithdrawalOnlyExistsValidator implements ValidatorWithArg<Withdrawal, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Withdrawal> ValidationResult<Withdrawal> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()))
				.put("partyTradeInformation", ExistenceChecker.isSet((List<? extends WithdrawalPartyTradeInformation>) o.getPartyTradeInformation()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("requestedAction", ExistenceChecker.isSet((RequestedWithdrawalAction) o.getRequestedAction()))
				.put("reason", ExistenceChecker.isSet((List<? extends WithdrawalReason>) o.getReason()))
				.put("reportingRegime", ExistenceChecker.isSet((List<? extends ReportingRegimeIdentifier>) o.getReportingRegime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Withdrawal", ValidationResult.ValidationType.ONLY_EXISTS, "Withdrawal", path, "");
		}
		return failure("Withdrawal", ValidationResult.ValidationType.ONLY_EXISTS, "Withdrawal", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
