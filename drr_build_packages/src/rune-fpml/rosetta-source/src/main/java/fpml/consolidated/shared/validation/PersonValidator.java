package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessUnitReference;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.Person;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PersonValidator implements Validator<Person> {

	private List<ComparisonResult> getComparisonResults(Person o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("honorific", (String) o.getHonorific() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstName", (String) o.getFirstName() != null ? 1 : 0, 0, 1), 
				checkCardinality("surname", (String) o.getSurname() != null ? 1 : 0, 0, 1), 
				checkCardinality("suffix", (String) o.getSuffix() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessUnitReference", (BusinessUnitReference) o.getBusinessUnitReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("contactInfo", (ContactInformation) o.getContactInfo() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateOfBirth", (ZonedDateTime) o.getDateOfBirth() != null ? 1 : 0, 0, 1), 
				checkCardinality("country", (CountryCode) o.getCountry() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Person o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Person", ValidationResult.ValidationType.CARDINALITY, "Person", path, "", res.getError());
				}
				return success("Person", ValidationResult.ValidationType.CARDINALITY, "Person", path, "");
			})
			.collect(toList());
	}

}
