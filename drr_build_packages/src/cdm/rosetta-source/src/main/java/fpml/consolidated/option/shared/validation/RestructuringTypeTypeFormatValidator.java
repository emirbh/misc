package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.RestructuringType;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RestructuringTypeTypeFormatValidator implements Validator<RestructuringType> {

	private List<ComparisonResult> getComparisonResults(RestructuringType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("restructuringScheme", o.getRestructuringScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RestructuringType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RestructuringType", ValidationResult.ValidationType.TYPE_FORMAT, "RestructuringType", path, "", res.getError());
				}
				return success("RestructuringType", ValidationResult.ValidationType.TYPE_FORMAT, "RestructuringType", path, "");
			})
			.collect(toList());
	}

}
