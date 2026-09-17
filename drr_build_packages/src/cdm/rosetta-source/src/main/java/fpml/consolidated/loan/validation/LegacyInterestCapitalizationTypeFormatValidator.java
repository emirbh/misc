package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LegacyInterestCapitalization;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class LegacyInterestCapitalizationTypeFormatValidator implements Validator<LegacyInterestCapitalization> {

	private List<ComparisonResult> getComparisonResults(LegacyInterestCapitalization o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyInterestCapitalization o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyInterestCapitalization", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyInterestCapitalization", path, "", res.getError());
				}
				return success("LegacyInterestCapitalization", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyInterestCapitalization", path, "");
			})
			.collect(toList());
	}

}
