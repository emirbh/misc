package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.TradeCategory;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WithdrawalPartyTradeInformationOnlyExistsValidator implements ValidatorWithArg<WithdrawalPartyTradeInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends WithdrawalPartyTradeInformation> ValidationResult<WithdrawalPartyTradeInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("accountReference", ExistenceChecker.isSet((AccountReference) o.getAccountReference()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("category", ExistenceChecker.isSet((List<? extends TradeCategory>) o.getCategory()))
				.put("reportingRegime", ExistenceChecker.isSet((List<? extends ReportingRegimeIdentifier>) o.getReportingRegime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WithdrawalPartyTradeInformation", ValidationResult.ValidationType.ONLY_EXISTS, "WithdrawalPartyTradeInformation", path, "");
		}
		return failure("WithdrawalPartyTradeInformation", ValidationResult.ValidationType.ONLY_EXISTS, "WithdrawalPartyTradeInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
