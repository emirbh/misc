package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.StreetAddress;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class StreetAddressTypeFormatValidator implements Validator<StreetAddress> {

	private List<ComparisonResult> getComparisonResults(StreetAddress o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("streetLine", o.getStreetLine(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StreetAddress o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StreetAddress", ValidationResult.ValidationType.TYPE_FORMAT, "StreetAddress", path, "", res.getError());
				}
				return success("StreetAddress", ValidationResult.ValidationType.TYPE_FORMAT, "StreetAddress", path, "");
			})
			.collect(toList());
	}

}
