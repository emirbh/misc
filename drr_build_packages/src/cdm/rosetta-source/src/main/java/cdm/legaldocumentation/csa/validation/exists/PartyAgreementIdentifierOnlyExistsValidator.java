package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legaldocumentation.csa.PartyAgreementIdentifier;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyAgreementIdentifierOnlyExistsValidator implements ValidatorWithArg<PartyAgreementIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyAgreementIdentifier> ValidationResult<PartyAgreementIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((ReferenceWithMetaParty) o.getPartyReference()))
				.put("documentIdentifier", ExistenceChecker.isSet((List<? extends FieldWithMetaIdentifier>) o.getDocumentIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyAgreementIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "PartyAgreementIdentifier", path, "");
		}
		return failure("PartyAgreementIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "PartyAgreementIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
