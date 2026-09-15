package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyTradeInformationSimple;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyTradeInformationSimpleOnlyExistsValidator implements ValidatorWithArg<PartyTradeInformationSimple, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyTradeInformationSimple> ValidationResult<PartyTradeInformationSimple> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("accountReference", ExistenceChecker.isSet((AccountReference) o.getAccountReference()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("reportingRegime", ExistenceChecker.isSet((List<? extends ReportingRegimeIdentifier>) o.getReportingRegime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyTradeInformationSimple", ValidationResult.ValidationType.ONLY_EXISTS, "PartyTradeInformationSimple", path, "");
		}
		return failure("PartyTradeInformationSimple", ValidationResult.ValidationType.ONLY_EXISTS, "PartyTradeInformationSimple", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
