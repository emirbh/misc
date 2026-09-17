package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.NonAccruingFeeTypeId;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class NonAccruingFeeTypeIdTypeFormatValidator implements Validator<NonAccruingFeeTypeId> {

	private List<ComparisonResult> getComparisonResults(NonAccruingFeeTypeId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("nonAccruingFeeTypeIdScheme", o.getNonAccruingFeeTypeIdScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonAccruingFeeTypeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonAccruingFeeTypeId", ValidationResult.ValidationType.TYPE_FORMAT, "NonAccruingFeeTypeId", path, "", res.getError());
				}
				return success("NonAccruingFeeTypeId", ValidationResult.ValidationType.TYPE_FORMAT, "NonAccruingFeeTypeId", path, "");
			})
			.collect(toList());
	}

}
