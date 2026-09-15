package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.TelephoneNumber;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class TelephoneNumberTypeFormatValidator implements Validator<TelephoneNumber> {

	private List<ComparisonResult> getComparisonResults(TelephoneNumber o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("number", o.getNumber(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TelephoneNumber o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TelephoneNumber", ValidationResult.ValidationType.TYPE_FORMAT, "TelephoneNumber", path, "", res.getError());
				}
				return success("TelephoneNumber", ValidationResult.ValidationType.TYPE_FORMAT, "TelephoneNumber", path, "");
			})
			.collect(toList());
	}

}
