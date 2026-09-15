package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.LegId;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LegIdTypeFormatValidator implements Validator<LegId> {

	private List<ComparisonResult> getComparisonResults(LegId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("value", o.getValue(), 1, empty(), empty()), 
				checkString("legIdScheme", o.getLegIdScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegId", ValidationResult.ValidationType.TYPE_FORMAT, "LegId", path, "", res.getError());
				}
				return success("LegId", ValidationResult.ValidationType.TYPE_FORMAT, "LegId", path, "");
			})
			.collect(toList());
	}

}
