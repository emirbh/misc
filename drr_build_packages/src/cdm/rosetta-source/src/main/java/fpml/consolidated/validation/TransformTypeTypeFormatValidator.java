package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.TransformType;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TransformTypeTypeFormatValidator implements Validator<TransformType> {

	private List<ComparisonResult> getComparisonResults(TransformType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("algorithm", o.getAlgorithm(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransformType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransformType", ValidationResult.ValidationType.TYPE_FORMAT, "TransformType", path, "", res.getError());
				}
				return success("TransformType", ValidationResult.ValidationType.TYPE_FORMAT, "TransformType", path, "");
			})
			.collect(toList());
	}

}
