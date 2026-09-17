package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Address;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.StreetAddress;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AddressValidator implements Validator<Address> {

	private List<ComparisonResult> getComparisonResults(Address o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("streetAddress", (StreetAddress) o.getStreetAddress() != null ? 1 : 0, 0, 1), 
				checkCardinality("city", (String) o.getCity() != null ? 1 : 0, 0, 1), 
				checkCardinality("state", (String) o.getState() != null ? 1 : 0, 0, 1), 
				checkCardinality("country", (CountryCode) o.getCountry() != null ? 1 : 0, 0, 1), 
				checkCardinality("postalCode", (String) o.getPostalCode() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Address o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Address", ValidationResult.ValidationType.CARDINALITY, "Address", path, "", res.getError());
				}
				return success("Address", ValidationResult.ValidationType.CARDINALITY, "Address", path, "");
			})
			.collect(toList());
	}

}
