package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated._Object;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class _ObjectTypeFormatValidator implements Validator<_Object> {

	private List<ComparisonResult> getComparisonResults(_Object o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("encoding", o.getEncoding(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, _Object o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("_Object", ValidationResult.ValidationType.TYPE_FORMAT, "_Object", path, "", res.getError());
				}
				return success("_Object", ValidationResult.ValidationType.TYPE_FORMAT, "_Object", path, "");
			})
			.collect(toList());
	}

}
