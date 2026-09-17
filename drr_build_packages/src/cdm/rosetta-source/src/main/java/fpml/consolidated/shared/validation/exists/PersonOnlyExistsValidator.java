package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessUnitReference;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.Person;
import fpml.consolidated.shared.PersonId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PersonOnlyExistsValidator implements ValidatorWithArg<Person, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Person> ValidationResult<Person> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("honorific", ExistenceChecker.isSet((String) o.getHonorific()))
				.put("firstName", ExistenceChecker.isSet((String) o.getFirstName()))
				.put("middleName", ExistenceChecker.isSet((List<String>) o.getMiddleName()))
				.put("initial", ExistenceChecker.isSet((List<String>) o.getInitial()))
				.put("surname", ExistenceChecker.isSet((String) o.getSurname()))
				.put("suffix", ExistenceChecker.isSet((String) o.getSuffix()))
				.put("personId", ExistenceChecker.isSet((List<? extends PersonId>) o.getPersonId()))
				.put("businessUnitReference", ExistenceChecker.isSet((BusinessUnitReference) o.getBusinessUnitReference()))
				.put("contactInfo", ExistenceChecker.isSet((ContactInformation) o.getContactInfo()))
				.put("dateOfBirth", ExistenceChecker.isSet((ZonedDateTime) o.getDateOfBirth()))
				.put("country", ExistenceChecker.isSet((CountryCode) o.getCountry()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Person", ValidationResult.ValidationType.ONLY_EXISTS, "Person", path, "");
		}
		return failure("Person", ValidationResult.ValidationType.ONLY_EXISTS, "Person", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
