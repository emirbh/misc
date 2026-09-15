package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessUnit;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.CreditRating;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.IndustryClassification;
import fpml.consolidated.shared.OrganizationType;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyGroupType;
import fpml.consolidated.shared.PartyId;
import fpml.consolidated.shared.PartyName;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Person;
import fpml.consolidated.shared.Region;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyOnlyExistsValidator implements ValidatorWithArg<Party, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Party> ValidationResult<Party> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("partyId", ExistenceChecker.isSet((List<? extends PartyId>) o.getPartyId()))
				.put("partyName", ExistenceChecker.isSet((PartyName) o.getPartyName()))
				.put("classification", ExistenceChecker.isSet((List<? extends IndustryClassification>) o.getClassification()))
				.put("creditRating", ExistenceChecker.isSet((List<? extends CreditRating>) o.getCreditRating()))
				.put("country", ExistenceChecker.isSet((CountryCode) o.getCountry()))
				.put("region", ExistenceChecker.isSet((List<? extends Region>) o.getRegion()))
				.put("jurisdiction", ExistenceChecker.isSet((List<? extends GoverningLaw>) o.getJurisdiction()))
				.put("organizationType", ExistenceChecker.isSet((List<? extends OrganizationType>) o.getOrganizationType()))
				.put("contactInfo", ExistenceChecker.isSet((ContactInformation) o.getContactInfo()))
				.put("businessUnit", ExistenceChecker.isSet((List<? extends BusinessUnit>) o.getBusinessUnit()))
				.put("person", ExistenceChecker.isSet((List<? extends Person>) o.getPerson()))
				.put("groupType", ExistenceChecker.isSet((PartyGroupType) o.getGroupType()))
				.put("partyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Party", ValidationResult.ValidationType.ONLY_EXISTS, "Party", path, "");
		}
		return failure("Party", ValidationResult.ValidationType.ONLY_EXISTS, "Party", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
