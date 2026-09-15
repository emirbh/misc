package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Address;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class AddressTypeFormatValidator implements Validator<Address> {

	private List<ComparisonResult> getComparisonResults(Address o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("city", o.getCity(), 1, empty(), empty()), 
				checkString("state", o.getState(), 1, empty(), empty()), 
				checkString("postalCode", o.getPostalCode(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Address o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Address", ValidationResult.ValidationType.TYPE_FORMAT, "Address", path, "", res.getError());
				}
				return success("Address", ValidationResult.ValidationType.TYPE_FORMAT, "Address", path, "");
			})
			.collect(toList());
	}

}
